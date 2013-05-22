#!/usr/bin/python

from math import trunc, floor
from re import sub
from sys import argv

global plain_txt, key_txt, output, cArray, collection

def preprocess(string):
        p = open(string).read()
        p = sub('[^A-Z]+', '', p)
        return p

def container():
	pad = [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
	return pad

def substitution(pArray, kArray, kTxt, digit, remainder):
	global cArray, output
	x, h, u, m, cArray = 0, 0, 0, 0, []

	while u <= digit:
		if u == digit:
			while m < remainder:
				cArray.append((pArray[h] + kArray[m]) %26)
				m +=1
				h +=1
		else:
			while x < len(kTxt):
				cArray.append((pArray[h] + kArray[x]) %26)
				x +=1
				h +=1
		u +=1
		x =0

	b, c = 0, []
	while b < len(cArray):
		c.append(chr(cArray[b] +65))
	
		b +=1

	i, cnt = 0, 0
        output.write('\n:input: padding\n')
        while i < len(c):
                if cnt <3:
			output.write(''.join(c[i]))
                       	cnt +=1
		else:
			output.write(''.join(c[i]) + '\n')
			cnt =0
                i +=1
	return c

def padding(lst):
	global output
	while len(lst) %16 !=0:
		lst.append('A')

	global cArray, collection
	cArray, collection = [], []

	i, row, col, cnt = 0, 0, 0, 0
	while i < (len(lst) /16):
		pad = container()
		while row <4:
			while col <4:
				pad[row][col] = lst[cnt]
				cArray.append(ord(lst[cnt]))
				col +=1
				cnt +=1
			row +=1
			col =0
		row =0
		i +=1
		collection.append(pad)
	
	output.write('\n\n:output:\n')
	for pad in collection:
		for row in pad:
			output.write(''.join(row))
			output.write('\n')
	
def rowShift():
	global collection
	i, j, k = 0, 0, 0

#	output.write('\n:input: rowShift\n')
#        for pad in collection:
#                for row in pad:
#                        output.write(''.join(row))
 #                       output.write('\n')


	output.write('\n:output: rowShift\n')
	for pad in collection:
		while j <4:
			while i <j:
				pad[j].append(pad[j].pop(0))
				i +=1
			while k <4:
				output.write(pad[j][k])
				pad[j][k] = parity(ord(pad[j][k]))
				k +=1
			output.write('\n')
			j +=1
			i, k = 0, 0
		j =0
	
def mixColumns():
	global collection
	rslt, j, k, g = [], 0, 0, 0
	mdx = [[2, 3, 1, 1],[1, 2, 3, 1],[1, 1, 2, 3],[3, 1, 1, 2]]
	blocks = [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
	
#	output.write('\n:input: mixColumns\n')
#        for pad in collection:
#                for row in pad:
#                        output.write(''.join(row))
#                        output.write('\n')

	output.write('\n:output: mixColumns\n')

	for pad in collection:
		while g <4:
			while j <4:	
				a_tmp =0
				while k <4:
					a_tmp ^= rgf(pad[k][g], mdx[j][k])
					k +=1
			
				blocks[j][g] = hex(a_tmp)[2:4]
				k =0
				j +=1
			g +=1
			j =0
		rslt.append(blocks)
		g =0
       	        for row in blocks:
               	        output.write(''.join(row))
                       	output.write('\n')

# checks parity of integer
# swaps to hex value
def parity(val):
	p, tmp = 0, val

	while(val):
		p +=1
		val &= (val-1)

	val = tmp
	if p%2  !=0:		# if odd
		val ^=128	  # flip MSB
		return (val)
	else: 
		return (tmp)

# performs multiplications by (1,2,3)
def rgf(x, y):
	tmp = x
	if y ==1:
		return x
	elif y ==2:
		if ((128 |x) ==x):
			return ((127 &x) <<1) ^27
		else:
			return x <<1
	elif y ==3:
		if ((128 |x) ==x):
			return (((127 &x) <<1) ^27) ^x
		else:
			return (((127 &x) <<1) ^x)

	else:
		print '::error:: wrong input'

def main():
	global output
	output = file('output.txt', 'w')
	# checking input parameters
	if len(argv) <=1:
		print "::error:: incorrect number of parameters"
	elif len(argv) >1:
		plain_txt = preprocess(argv[1])
		key_txt = preprocess(argv[2])
		
		output.write('plain_txt ' + str(len(plain_txt)) + ' ' + plain_txt + '\n')
		output.write('key_txt   ' + str(len(plain_txt)) + ' ' + key_txt + '\n')

		# A-Z == 0-25
		plain_ary = []
		cnt =0
		for x in plain_txt:
			# appends int value of char to array
			plain_ary.append(ord(plain_txt[cnt]) -65)
			cnt +=1
		key_ary = []
		cnt =0
		for x in key_txt:
			key_ary.append(ord(key_txt[cnt]) -65)
			cnt +=1

		# determine how many times to wrap key
		d = trunc(floor(len(plain_txt) / len(key_txt)))
		r = len(plain_txt) % len(key_txt)

		padding(substitution(plain_ary, key_ary, key_txt, d, r))

		rowShift()
		mixColumns()
		
if __name__ == '__main__':
	main()
