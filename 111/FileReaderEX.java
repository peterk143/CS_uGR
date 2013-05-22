Student [] book = new Student[100];

FileReader reader = new FileReader("students.txt");

Scanner infile = new Scanner(reader);
int i = 0;

while(i < 10)
{
  Student newStudent = new Student(infile.next(), infile.next(), infile.next(), //do this as many times as needed);
  book[i] = newStudent;
  i++;
}
    
    