package dss

/**
 * User: Dmytro Vynokurov
 * Date: 10/22/13
 * Time: 10:40 AM
 */
case class Rule(left:List[Fact], right:Fact){
  override def toString: String = (for(rule<-left)yield rule.toString).mkString(", ") + " |= " + right.toString
}
object Rule{
  implicit def Fact2FactAsList(fact:Fact):FactAsList = new FactAsList(fact)
  implicit def Facts2FactList(left: List[Fact]):FactList = new FactList(left)
}

class FactAsList(val first:Fact){
  def ::(second:Fact):List[Fact] = second :: first :: Nil
}

class FactList(val left:List[Fact]){
  def |=(right:Fact):Rule = new Rule(left,right)
}
