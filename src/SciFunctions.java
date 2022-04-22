import java.lang.Math;

class SciFunctions {
	 public static Double AbsoluteValue(Double x)
	 {
		return Math.abs(x);
	 }
	 public static Double SquareRoot(Double y)
	 {
		return  Math.sqrt(y);
	 }
	 public static Double CubeRoot(Double z)
	 {
		return  Math.cbrt(z);
	 }
	 public static Double Sine(Double a)
	 {
		 if(SelectAngle.getAngleUnit()) {
			a = Math.toRadians(a);
		 }
		return  Math.sin(a);
	 }
	 public static Double SineInverse(Double b)
	 {
		if(SelectAngle.getAngleUnit()) {
			b = Math.toRadians(b);
		 }
		return Math.asin(b);
	 }
	 public static Double Cosine(Double c)
	 {
		if(SelectAngle.getAngleUnit()) {
			if((c/90.0) % 2 == 1) {
				return 0.0;
			}
			c = Math.toRadians(c);
		 }
		return  Math.cos(c);
	 }
	 public static Double  CosineInverse(Double d)
	 {
		if(SelectAngle.getAngleUnit()) {
			d = Math.toRadians(d);
		 }
		return  Math.acos(d);
	 }
	 public static Double  Tangent(Double e)
	 {
		if(SelectAngle.getAngleUnit()) {
			e = Math.toRadians(e);
		 }
		return  Math.tan(e);
	 }
	 public static Double  TangentInverse(Double f)
	 {
		if(SelectAngle.getAngleUnit()) {
			f = Math.toRadians(f);
		 }
		return  Math.atan(f);
	 }
	 public static Double  SineHyperbolic(Double g)
	 {
		if(SelectAngle.getAngleUnit()) {
			g = Math.toRadians(g);
		 }
		return  Math.sinh(g);
	 }
	 public static Double  CosineHyperbolic(Double x)
	 {
		if(SelectAngle.getAngleUnit()) {
			x = Math.toRadians(x);
		 }
		return Math.cosh(x); 
	 }
	 public static Double  TangentHyperbolic(Double x)
	 {
		if(SelectAngle.getAngleUnit()) {
			x = Math.toRadians(x);
		 }
		return  Math.tanh(x);
	 }
	 public static Double  Power(Double x,Double y)
	 {
		return Math.pow(x, y);
	 }
}

