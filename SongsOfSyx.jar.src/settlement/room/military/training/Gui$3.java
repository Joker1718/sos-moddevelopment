/*     */ package settlement.room.military.training;
/*     */ 
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/*  86 */     GFORMAT.perc(text, get());
/*     */   }
/*     */   
/*     */   double get() {
/*  90 */     return IndustryUtil.calcProductionRate(1.0D, null, Gui.this.blueprint.bonus(), (RoomInstance)getter.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/*  95 */     b.title(Gui.¤¤speed);
/*  96 */     b.text(Gui.¤¤speedD);
/*     */     
/*  98 */     IndustryUtil.hoverProductionRate((GUI_BOX)b, 1.0D, null, Gui.this.blueprint.bonus(), (RoomInstance)getter.get());
/*     */     
/* 100 */     b.NL(8);
/* 101 */     b.textLL(Gui.¤¤maxLevel);
/*     */     
/* 103 */     double d = get();
/* 104 */     int am = (int)Math.ceil(Gui.this.blueprint.TRAINING_DAYS / d);
/*     */     
/* 106 */     b.add((SPRITE)GFORMAT.i(b.text(), am));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\Gui$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */