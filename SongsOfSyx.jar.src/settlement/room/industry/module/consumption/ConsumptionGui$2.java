/*     */ package settlement.room.industry.module.consumption;
/*     */ 
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 102 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 107 */     ConsumptionGui.this.cons.enabledToggle(rr, (ROOM_IDATA_INSTANCE)getter.get(), (RoomInstance)getter.get());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 112 */     selectedSet(ConsumptionGui.this.cons.enabled(rr, (ROOM_IDATA_INSTANCE)getter.get()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 117 */     GBox b = (GBox)text;
/* 118 */     GText t = b.text();
/* 119 */     t.add(ConsumptionGui.¤¤use);
/* 120 */     t.insert(0, 1.0D + ConsumptionGui.this.cons.boost(rr), 2);
/* 121 */     b.add((SPRITE)t);
/* 122 */     b.NL();
/*     */     
/* 124 */     b.textLL(ConsumptionGui.¤¤Stored);
/* 125 */     b.tab(6);
/* 126 */     b.add((SPRITE)GFORMAT.i(b.text(), ConsumptionGui.this.cons.stored(rr).get(getter.get())));
/* 127 */     b.NL();
/* 128 */     b.textLL(ConsumptionGui.¤¤Incoming);
/* 129 */     b.tab(6);
/* 130 */     b.add((SPRITE)GFORMAT.i(b.text(), ConsumptionGui.this.cons.reseved(rr).get(getter.get())));
/* 131 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 135 */     b.sep();
/*     */ 
/*     */ 
/*     */     
/* 139 */     ConsumptionGui.hoverConsumptionIns(text, rr, (RoomInstance)getter.get(), ConsumptionGui.this.cons);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\ConsumptionGui$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */