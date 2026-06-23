/*     */ package world.army;
/*     */ 
/*     */ import init.resources.ResSupply;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.entity.army.WArmy;
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
/*     */ public final class ADSupplyRes
/*     */   extends ADSupply
/*     */ {
/*     */   public final ResSupply res;
/*     */   
/*     */   ADSupplyRes(int index, ADInit init, ResSupply rs) {
/* 229 */     super(index, "SUPPLY", init, rs.resource, Dic.¤¤Supplies, rs.consumptionPerPersonday, rs.consumptionPerItemPerDay, rs.morale, rs.health);
/* 230 */     this.res = rs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void add(WArmy a) {
/* 235 */     for (int di = 0; di < a.divs().size(); di++) {
/* 236 */       ADDiv d = a.divs().get(di);
/* 237 */       if (d.needSupplies()) {
/* 238 */         this.consumers.inc(a, this.res.consumedMulPerDay(d.race()) * d.men());
/* 239 */         this.consumersMax.inc(a, this.res.consumedMulPerDay(d.race()) * d.menTarget());
/* 240 */         this.amountNeeded.inc(a, this.res.consumedMulPerDay(d.race()) * this.res.wantedPerPerson * d.men());
/* 241 */         this.amountNeededMax.inc(a, this.res.consumedMulPerDay(d.race()) * this.res.wantedPerPerson * d.menTarget());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void transfer(WDIV div, WArmy old, WArmy current) {
/* 249 */     double divAmount = (this.res.consumedMulPerDay(div.race()) * div.menTarget());
/* 250 */     double armyAmount = this.consumersMax.get(old);
/* 251 */     if (armyAmount == 0.0D)
/*     */       return; 
/* 253 */     int am = (int)(current().get(old) * divAmount / armyAmount);
/* 254 */     if (am > 0) {
/* 255 */       current().inc(old, -am);
/* 256 */       current().inc(current, am);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, WArmy a) {
/* 263 */     this.res.hover(b);
/*     */     
/* 265 */     b.sep();
/*     */     
/* 267 */     int m = 6;
/*     */     
/* 269 */     b.textL(ADSupply.¤¤affected);
/* 270 */     b.tab(m);
/* 271 */     b.add((SPRITE)GFORMAT.i(b.text(), this.consumers.get(a)));
/* 272 */     b.NL();
/*     */     
/* 274 */     b.textL(Dic.¤¤Minimum);
/* 275 */     b.tab(m);
/* 276 */     b.add((SPRITE)GFORMAT.i(b.text(), minimumAmount(a)));
/* 277 */     b.NL();
/*     */     
/* 279 */     b.textL(Dic.¤¤Max);
/* 280 */     b.tab(m);
/* 281 */     b.add((SPRITE)GFORMAT.i(b.text(), targetAmount(a)));
/* 282 */     b.NL();
/*     */     
/* 284 */     b.textL(Dic.¤¤Stored);
/* 285 */     b.tab(m);
/* 286 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), current().get(a), targetAmount(a)));
/* 287 */     b.NL();
/*     */     
/* 289 */     b.textL(ADSupply.¤¤ConsumtionRate);
/* 290 */     b.tab(m);
/* 291 */     b.add((SPRITE)GFORMAT.f0(b.text(), -consumedPerDayCurrent(a)));
/* 292 */     b.NL();
/*     */     
/* 294 */     b.textL(ADSupply.¤¤days);
/* 295 */     b.tab(m);
/* 296 */     b.add((SPRITE)GFORMAT.f0(b.text(), daysStored(a)));
/* 297 */     b.NL();
/*     */     
/* 299 */     if (this.baseMorale > 0.0D) {
/* 300 */       b.textL(Dic.¤¤Morale);
/* 301 */       b.tab(m);
/* 302 */       b.add((SPRITE)GFORMAT.f0(b.text(), moraleAdd(a)));
/* 303 */       b.NL();
/*     */     } 
/* 305 */     if (this.baseHealth > 0.0D) {
/* 306 */       b.textL(Dic.¤¤Health);
/* 307 */       b.tab(m);
/* 308 */       GText t = b.text();
/* 309 */       t.add('*').s();
/* 310 */       b.add((SPRITE)GFORMAT.f1(t, healthMul(a)));
/* 311 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSupply$ADSupplyRes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */