/*     */ package world.army;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ADSupplyArt
/*     */   extends ADSupply
/*     */ {
/*     */   public final ADSupplies.ADArtillery art;
/*     */   public final int ri;
/*     */   
/*     */   ADSupplyArt(int index, ADInit init, ADSupplies.ADArtillery art, RESOURCE res, int ri) {
/* 392 */     super(index, "ART_" + art.art.key + "_" + res.key, init, res, art.art.info.name, 0.0D, 0.2D / TIME.years().bitConversion((TIMECYCLE)TIME.days()), 0.0D, 0.0D);
/* 393 */     this.art = art;
/* 394 */     this.ri = ri;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void add(WArmy a) {
/* 400 */     int am = (int)Math.ceil(this.art.target.get(a) * this.art.art.constructor().item(1).cost2(this.ri, this.art.art.upgrades().max()));
/* 401 */     this.amountNeeded.set(a, am);
/* 402 */     this.amountNeededMax.set(a, am);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void transfer(WDIV div, WArmy old, WArmy current) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, WArmy a) {
/* 413 */     b.title(this.name);
/* 414 */     b.text(ADSupply.¤¤artD);
/*     */     
/* 416 */     b.sep();
/*     */     
/* 418 */     b.textL(Dic.¤¤Minimum);
/* 419 */     b.tab(6);
/* 420 */     b.add((SPRITE)GFORMAT.i(b.text(), minimumAmount(a)));
/* 421 */     b.NL();
/*     */     
/* 423 */     b.textL(Dic.¤¤Max);
/* 424 */     b.tab(6);
/* 425 */     b.add((SPRITE)GFORMAT.i(b.text(), targetAmount(a)));
/* 426 */     b.NL();
/*     */     
/* 428 */     b.textL(Dic.¤¤Stored);
/* 429 */     b.tab(6);
/* 430 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), current().get(a), targetAmount(a)));
/* 431 */     b.NL();
/*     */     
/* 433 */     b.textL(ADSupply.¤¤ConsumtionRate);
/* 434 */     b.tab(6);
/* 435 */     b.add((SPRITE)GFORMAT.f0(b.text(), -consumedPerDayCurrent(a)));
/* 436 */     b.NL();
/*     */     
/* 438 */     b.textL(ADSupply.¤¤days);
/* 439 */     b.tab(6);
/* 440 */     b.add((SPRITE)GFORMAT.f0(b.text(), daysStored(a)));
/* 441 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSupply$ADSupplyArt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */