/*     */ package settlement.room.tests;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.tests.production.Input;
/*     */ import settlement.room.tests.production.ProductionSpec;
/*     */ import settlement.room.tests.production.TestRecipe;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.sets.LIST;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BonusPlayer
/*     */   implements ProductionSpec
/*     */ {
/* 100 */   private final double[] bonus = new double[Industry.all().size()];
/* 101 */   private final double[] cons = new double[Industry.all().size()];
/*     */   
/* 103 */   final ProductionSpec spec = new ProductionSpec()
/*     */     {
/*     */       public double wPerItemUsed()
/*     */       {
/* 107 */         return 0.05D;
/*     */       }
/*     */ 
/*     */       
/*     */       public double consumptionBonus(Industry ins) {
/* 112 */         return 1.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public double bonus(Industry ins) {
/* 117 */         return 1.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public double addedW() {
/* 122 */         return 0.05D;
/*     */       }
/*     */     };
/*     */   
/*     */   BonusPlayer() {
/* 127 */     clear();
/*     */ 
/*     */ 
/*     */     
/* 131 */     recount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void recount() {
/* 138 */     double toll = 0.05D;
/* 139 */     double buyT = 0.0D;
/* 140 */     double sellT = 0.2D;
/*     */     
/* 142 */     Arrays.fill(this.cons, 1.0D);
/* 143 */     Arrays.fill(this.bonus, 1.0D);
/* 144 */     UITradeDebug.this.bonusai.set(100);
/*     */     
/* 146 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 147 */       LOG.ln(r.key + " " + r.key);
/* 148 */       LOG.ln("buy " + 400 * UITradeDebug.this.trade.sellPrice(r, this.spec, 1.0D, 0.0D, 0.05D));
/* 149 */       LOG.ln("sell " + 400 * UITradeDebug.this.trade.buyPrice(r, this.spec, 1.0D, 0.2D, 0.05D));
/* 150 */       LIST<TestRecipe> rs = UITradeDebug.this.data.get(r);
/*     */       
/* 152 */       for (TestRecipe rr : rs) {
/* 153 */         double t = rr.pricePerItem(this.spec);
/* 154 */         LOG.ln("    " + t + " " + rr.rate + " " + rr.wPerItem(this.spec));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     boolean change = true;
/* 162 */     while (change) {
/* 163 */       change = false;
/*     */ 
/*     */ 
/*     */       
/* 167 */       for (Industry ins : (SETT.ROOMS()).industries.all) {
/*     */ 
/*     */         
/* 170 */         for (TestRecipe r : UITradeDebug.this.data.get(ins)) {
/*     */ 
/*     */           
/* 173 */           int expenditure = 0;
/* 174 */           for (Input i : r.inputs()) {
/* 175 */             double d = this.spec.bonus(ins) * i.amount;
/* 176 */             expenditure += UITradeDebug.this.trade.buyPrice(i.res, this.spec, d, 0.0D, 0.05D);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 181 */           double amount = this.spec.bonus(ins) * r.rate;
/*     */           
/* 183 */           int income = UITradeDebug.this.trade.sellPrice(r.res, this.spec, amount, 0.2D, 0.05D);
/*     */           
/* 185 */           double cr = 400.0D - amount * 0.05D - 80.0D;
/*     */           
/* 187 */           if (expenditure > 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 192 */             double c = (income - cr) / expenditure;
/* 193 */             LOG.ln(ins.blue.key + " " + ins.blue.key + " " + r.rate + " " + income + " " + -expenditure + " " + c);
/* 194 */             if (c < 1.0D) {
/*     */               
/* 196 */               c = 1.0D / c;
/* 197 */               if (c > this.cons[ins.index()]) {
/* 198 */                 this.cons[ins.index()] = c;
/* 199 */                 change = true;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 209 */     LOG.ln();
/* 210 */     for (Industry ins : (SETT.ROOMS()).industries.all) {
/* 211 */       if (ins.outs().size() == 0)
/*     */         continue; 
/* 213 */       String s = " | " + String.valueOf(((IndustryResource)ins.outs().get(0)).resource.name) + " -> ";
/* 214 */       for (IndustryResource ii : ins.ins())
/* 215 */         s = s + s + ", "; 
/* 216 */       LOG.ln(ins.blue.key + " " + ins.blue.key + (int)((this.cons[ins.index()] - 1.0D) * 100.0D) / 100.0D);
/*     */     } 
/*     */ 
/*     */     
/* 220 */     for (Industry ins : (SETT.ROOMS()).industries.all) {
/* 221 */       if (ins.outs().size() == 0)
/*     */         continue; 
/* 223 */       String s = " | " + String.valueOf(((IndustryResource)ins.outs().get(0)).resource.name) + " -> ";
/* 224 */       for (IndustryResource ii : ins.ins())
/* 225 */         s = s + s + ", "; 
/* 226 */       LOG.ln(ins.blue.key + " " + ins.blue.key + (int)((this.cons[ins.index()] - 1.0D) * 100.0D) / 100.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double bonus(Industry t) {
/* 234 */     return this.bonus[t.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double consumptionBonus(Industry ins) {
/* 239 */     return 1.0D * (1.0D - UITradeDebug.this.consumptionBonus.getD()) + this.cons[ins.index()] * UITradeDebug.this.consumptionBonus.getD();
/*     */   }
/*     */   
/*     */   void clear() {
/* 243 */     Arrays.fill(this.bonus, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double wPerItemUsed() {
/* 249 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double addedW() {
/* 254 */     return UITradeDebug.this.gametheory.getD();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\UITradeDebug$BonusPlayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */