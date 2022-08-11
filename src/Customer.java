
public class Customer {
private String name;
private String nid;
private int age;
private int phoneNumber;
private String nationality;
void setName(String name) {
	this.name=name;
}
void setNid(String nid) {
	this.nid=nid;
}
void setAge(int age) {
	this.age=age;
}
void setphoneNumber(int phoneNumber) {
	this.phoneNumber=phoneNumber;
}
void setNationality(String nationality) {
	this.nationality=nationality;
}
String getName() {
	return this.name;
}
String getNid() {
	return this.nid;
}
int getAge() {
	return this.age;
}
int getphoneNumber() {
	return this.phoneNumber;
}
String getNationality() {
	return this.nationality;
}
}
