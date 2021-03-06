/*Tyler Gray
 * Extends DiscountPolicy
 * Takes two discounts and determines which discount is better
 */
public class CombinedDiscount extends DiscountPolicy {

	private DiscountPolicy dis1;
	private DiscountPolicy dis2;
	public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2) {
		this.dis1 = dis1;
		this.dis2 = dis2;
	}
	
	@Override
	public double computeDiscount(int quantity, double itemCost) {
		return Math.max(dis1.computeDiscount(quantity, itemCost),dis2.computeDiscount(quantity, itemCost)) ;
		
	}

}
