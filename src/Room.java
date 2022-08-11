
public abstract class Room {
int roomNo;
String roomType;
double deluxCost;
double normalCost;
void setroomNo(int roomNo) {
	this.roomNo=roomNo;
}
void setroomType(String roomType) {
	this.roomType=roomType;
}
void setDeluxCost(double deluxCost) {
	this.deluxCost=deluxCost;
}
void setNormalCost(double normalCost) {
	this.normalCost=normalCost;
}
int getroomNo() {
	return this.roomNo;
}
String getroomType() {
	return this.roomType;
}
double getDeluxCost() {
	return this.deluxCost;
}
double getNormalCost() {
	return this.normalCost;
}
abstract void getCustomerNumber();
}
