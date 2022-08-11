
public class Employee {
private String name;
private String id;
private int age;
private String nationality;
private String designation;
Employee(){
	
}
void setName(String name) {
	this.name=name;
}
void setId(String id) {
	this.id=id;
}
void setAge(int age) {
	this.age=age;
}
void setNationality(String nationality) {
	this.nationality=nationality;
}
void setDesignation(String designation) {
	this.designation=designation;
}
String getName() {
	return this.name;
}
String getId() {
	return this.id;
}
int getAge() {
	return this.age;
}
String getNationality() {
	return this.nationality;
}
String getDesignation() {
	return this.designation;
}

}
