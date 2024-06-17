//Q1
def AreaOfDisk(r:Double)=math.Pi*r*r
//Q2
def CtoF(c:Double):Double=c*1.8+32.00
//Q3
def Vsphere(r:Double):Double=4.0/3.0*math.Pi*r*r*r
//Q5
def easy(d:Double):Double=d*8
def tempo(d2:Double):Double=d2*7
//Q4
def bprice(x:Double)=x*24.95
def discount(x:Double)=x*0.4
def shipcost(x:Double)=if(x<=50) 3 else 3+(x-50)*0.75
val tot=bprice(60)+shipcost(60)-discount(60)