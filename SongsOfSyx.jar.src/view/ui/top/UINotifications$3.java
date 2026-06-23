/*     */ package view.ui.top;
/*     */ 
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UINotifications.UINotification
/*     */ {
/*     */   private short ci;
/*     */   private ThingsCorpses.Corpse corpse;
/*     */   
/*     */   null(SPRITE $anonymous0, COLOR $anonymous1, boolean $anonymous2) {
/* 179 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */ 
/*     */     
/* 182 */     this.ci = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get() {
/* 187 */     return (SETT.THINGS()).corpses.nrOfCorpses();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 192 */     GBox b = (GBox)text;
/* 193 */     b.title(((STATS.ENV()).UNBURRIED.info()).name);
/* 194 */     for (CAUSE_LEAVE c : CAUSE_LEAVES.ALL()) {
/* 195 */       int am = (SETT.THINGS()).corpses.amount(c);
/* 196 */       if (am != 0) {
/* 197 */         b.textL(c.name);
/* 198 */         b.tab(4);
/* 199 */         b.add((SPRITE)GFORMAT.i(b.text(), (SETT.THINGS()).corpses.amount(c)));
/* 200 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 204 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 209 */     if (this.corpse == null || this.corpse.isRemoved()) {
/* 210 */       this.corpse = getCorpse();
/*     */     }
/* 212 */     if (this.corpse != null) {
/* 213 */       VIEW.s().activate();
/* 214 */       (VIEW.s().getWindow()).centererTile.set(this.corpse.ctx(), this.corpse.cty());
/* 215 */       this.corpse = (SETT.THINGS()).corpses.getNext(this.corpse);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ThingsCorpses.Corpse getCorpse() {
/* 220 */     for (int i = 0; i < 8192; i++) {
/*     */       
/* 222 */       ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex(this.ci);
/* 223 */       if (c != null) {
/* 224 */         return c;
/*     */       }
/* 226 */       this.ci = (short)(this.ci + 1);
/* 227 */       this.ci = (short)(this.ci % 8192);
/*     */     } 
/* 229 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UINotifications$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */