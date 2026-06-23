/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 122 */     super($anonymous0);
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
/*     */   protected void clickA() {
/* 134 */     UIPanelMain.this.last().add(UIPanelMain.this.tools[w.index()], false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 140 */     GBox b = (GBox)text;
/* 141 */     b.add(w.info);
/* 142 */     b.NL();
/* 143 */     b.textLL(Dic.¤¤Equipped);
/* 144 */     b.tab(6);
/* 145 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), w.currentTotal(), w.neededTotal()));
/*     */     
/* 147 */     b.NL();
/* 148 */     b.add((SPRITE)b.text().add(Dic.¤¤Consumed).s().add('(').add(DicTime.¤¤Day).add(')'));
/* 149 */     b.tab(6);
/* 150 */     b.add((SPRITE)GFORMAT.f0(b.text(), -w.currentTotal() * w.degradePerDay));
/*     */     
/* 152 */     b.sep();
/* 153 */     w.boosts.hover(text, 1.0D, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 161 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 162 */     double d = w.currentTotal() / w.neededTotal();
/* 163 */     Rec.TEMP.setDim((this.body.width() - 8), (this.body.height() - 8));
/* 164 */     Rec.TEMP.centerIn((RECTANGLE)this.body);
/*     */     
/* 166 */     if (w.neededTotal() > 0) {
/* 167 */       GMeter.render(r, GMeter.C_GRAY, d, (RECTANGLE)Rec.TEMP);
/*     */     }
/* 169 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIPanelMain$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */