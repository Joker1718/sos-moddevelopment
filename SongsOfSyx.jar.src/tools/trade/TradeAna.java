/*     */ package tools.trade;
/*     */ 
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ 
/*     */ public class TradeAna
/*     */ {
/*   7 */   public static double price = 1000.0D;
/*   8 */   public static double buyPenalty = 1.0D;
/*   9 */   public static double sellPenalty = 0.5D;
/*  10 */   public static double toll = 200.0D;
/*  11 */   public static double addedToPrice = 50.0D;
/*  12 */   private final ArrayListGrower<Recipe> recs = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TradeAna() {
/*  23 */     Recipe grain = new Recipe("Grain", 0.1D);
/*  24 */     Recipe rr = new Recipe("Bread", 0.1D);
/*  25 */     rr.inputs.add(new Input(grain, 1.0D));
/*     */ 
/*     */     
/*  28 */     Recipe wood = new Recipe("Wood", 1.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     rr = new Recipe("Sculpture", 1.0D);
/*  35 */     rr.inputs.add(new Input(wood, 0.1D));
/*     */     
/*  37 */     rr = new Recipe("Plank", 1.0D);
/*  38 */     rr.inputs.add(new Input(wood, 1.0D));
/*     */     
/*  40 */     rr = new Recipe("Furniture", 1.0D);
/*  41 */     rr.inputs.add(new Input(wood, 10.0D));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     System.out.println("1 W = $" + price);
/*  55 */     System.out.println("" + toll + "%");
/*  56 */     System.out.println();
/*     */ 
/*     */ 
/*     */     
/*  60 */     for (Recipe r : this.recs) {
/*  61 */       System.out.print(r.name + " -> ");
/*  62 */       for (Input i : r.inputs) {
/*  63 */         System.out.print("" + i.amount * i.modifier + i.amount * i.modifier + " + ");
/*     */       }
/*  65 */       System.out.println("" + r.w + "W $" + r.w + " " + r.price() + " " + r.sellprice(1.0D));
/*     */     } 
/*     */     
/*  68 */     System.out.println();
/*  69 */     System.out.println("Start of game game. 200 in toll per item both ways per goods. The AI adds 200 to the price in 'game theory'. AI's start off hostile, so 50% tariff on your sell price.");
/*  70 */     print();
/*     */ 
/*     */     
/*  73 */     System.out.println();
/*  74 */     System.out.println("Early game. You have close neighbours, so decreasing toll to 100 and tariff to 0.9");
/*  75 */     toll = 50.0D;
/*  76 */     sellPenalty = 1.0D;
/*  77 */     print();
/*     */ 
/*     */ 
/*     */     
/*  81 */     System.out.println();
/*  82 */     System.out.println("adding early tech according to cost");
/*  83 */     for (Recipe r : this.recs) {
/*     */       
/*  85 */       double ptot = r.price();
/*  86 */       double p = r.wp * price + addedToPrice;
/*     */       
/*  88 */       double tech = ptot / p;
/*  89 */       r.w /= 2.0D * tech;
/*  90 */       System.out.println("adding a x" + 2.0D * tech + " boost to  " + r.name);
/*     */     } 
/*     */ 
/*     */     
/*  94 */     print();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     System.out.println();
/*     */   }
/*     */ 
/*     */   
/*     */   private void print() {
/* 130 */     for (Recipe r : this.recs) {
/* 131 */       print(r);
/* 132 */       System.out.println();
/*     */     } 
/* 134 */     System.out.println("----------------------------------");
/* 135 */     System.out.println();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void print(Recipe r) {
/* 141 */     System.out.print(r.name + " -> ");
/*     */     
/* 143 */     double intot = 0.0D;
/*     */     
/* 145 */     for (Input i : r.inputs) {
/* 146 */       System.out.print("" + i.amount * i.modifier + i.amount * i.modifier + " + ");
/* 147 */       intot += i.amount * i.modifier;
/*     */     } 
/* 149 */     System.out.println("" + r.w + "W $" + r.w);
/*     */ 
/*     */ 
/*     */     
/* 153 */     System.out.print("A: ");
/* 154 */     if (r.inputs.size() == 0) {
/* 155 */       System.out.println("-");
/*     */     } else {
/* 157 */       int i = 0;
/*     */ 
/*     */ 
/*     */       
/* 161 */       for (Input input : r.inputs) {
/* 162 */         double d = input.res.produced() * input.modifier * input.amount / intot;
/* 163 */         i = (int)(i + input.res.sellprice(d));
/*     */       } 
/* 165 */       System.out.print("$" + i + "    (");
/* 166 */       for (Input input : r.inputs) {
/* 167 */         double d = input.res.produced() * input.modifier * input.amount / intot;
/* 168 */         System.out.print("" + d + d + "$" + input.res.name + ",   ");
/*     */       } 
/* 170 */       System.out.println(")");
/*     */     } 
/*     */ 
/*     */     
/* 174 */     System.out.print("B: ");
/* 175 */     if (r.inputs.size() == 0) {
/* 176 */       System.out.println("-");
/*     */     } else {
/*     */       
/* 179 */       double tot = 0.0D;
/* 180 */       for (Input input : r.inputs) {
/* 181 */         tot += input.amount * input.res.w;
/*     */       }
/* 183 */       tot += r.w;
/*     */       
/* 185 */       double d1 = r.produced() * r.w / tot;
/* 186 */       int i = (int)r.sellprice(d1);
/* 187 */       System.out.print("$" + i + "    (");
/*     */       
/* 189 */       for (Input input : r.inputs) {
/* 190 */         double p = input.res.produced() * input.modifier * input.amount * input.res.w / tot;
/* 191 */         System.out.print("" + p + p + ",   ");
/*     */       } 
/*     */       
/* 194 */       System.out.println("" + d1 + d1 + "$" + r.name + ")");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 199 */     System.out.print("C: ");
/*     */ 
/*     */     
/* 202 */     double produced = r.produced();
/* 203 */     double imports = 0.0D;
/*     */     
/* 205 */     for (Input i : r.inputs) {
/* 206 */       double am = produced * i.modifier * i.amount;
/* 207 */       imports += i.res.buyprice(am);
/*     */     } 
/*     */     
/* 210 */     double earnings = r.sellprice(produced);
/* 211 */     earnings -= imports;
/*     */     
/* 213 */     System.out.print("$" + (int)earnings + "    (");
/*     */     
/* 215 */     for (Input i : r.inputs) {
/* 216 */       double am = produced * i.modifier * i.amount;
/* 217 */       double p = i.res.buyprice(am);
/* 218 */       System.out.print("-" + am + i.res.name + "$" + p + ",   ");
/*     */     } 
/* 220 */     System.out.println("+" + produced + r.name + "$" + r.sellprice(produced) + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Recipe
/*     */   {
/* 261 */     final ArrayListGrower<TradeAna.Input> inputs = new ArrayListGrower();
/*     */     double w;
/*     */     final double wp;
/*     */     final String name;
/* 265 */     double tollAmount = 1.0D;
/*     */     
/*     */     Recipe(String name, double w) {
/* 268 */       this.name = name;
/* 269 */       this.w = w;
/* 270 */       this.wp = w;
/* 271 */       TradeAna.this.recs.add(this);
/*     */     }
/*     */ 
/*     */     
/*     */     double produced() {
/* 276 */       return 1.0D / this.w;
/*     */     }
/*     */ 
/*     */     
/*     */     double buyprice(double amount) {
/* 281 */       double price = price();
/* 282 */       price = price * TradeAna.buyPenalty * amount;
/* 283 */       return price + TradeAna.toll * amount;
/*     */     }
/*     */     
/*     */     double sellprice(double amount) {
/* 287 */       double price = price();
/* 288 */       price = price * TradeAna.sellPenalty * amount;
/* 289 */       return price - TradeAna.toll * amount;
/*     */     }
/*     */ 
/*     */     
/*     */     double price() {
/* 294 */       double p = this.wp * TradeAna.price;
/* 295 */       for (TradeAna.Input i : this.inputs) {
/* 296 */         p += i.res.price() * i.amount;
/*     */       }
/* 298 */       return p + TradeAna.addedToPrice * this.tollAmount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Input
/*     */   {
/*     */     final TradeAna.Recipe res;
/*     */ 
/*     */ 
/*     */     
/*     */     final double amount;
/*     */ 
/*     */ 
/*     */     
/* 315 */     double modifier = 1.0D;
/*     */     
/*     */     Input(TradeAna.Recipe res, double amount) {
/* 318 */       this.res = res;
/* 319 */       this.amount = amount;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\trade\TradeAna.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */