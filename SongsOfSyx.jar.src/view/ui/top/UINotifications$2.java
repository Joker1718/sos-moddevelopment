/*     */ package view.ui.top;
/*     */ 
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.LinkedList;
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
/*     */ class null
/*     */   extends UINotifications.UINotification
/*     */ {
/*     */   LinkedList<CAUSE_LEAVE> wrongful;
/*     */   private int ci;
/*     */   private ThingsCorpses.Corpse corpse;
/*     */   
/*     */   null(SPRITE $anonymous0, COLOR $anonymous1, boolean $anonymous2) {
/* 115 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */     
/* 117 */     this.wrongful = new LinkedList();
/*     */ 
/*     */     
/* 120 */     for (CAUSE_LEAVE l : CAUSE_LEAVES.ALL()) {
/* 121 */       if (l.defaultStanding() > 0.0D) {
/* 122 */         this.wrongful.add(l);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 127 */     this.ci = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get() {
/* 132 */     int i = 0;
/* 133 */     for (CAUSE_LEAVE c : this.wrongful) {
/* 134 */       i += (SETT.THINGS()).corpses.amount(c);
/*     */     }
/* 136 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 141 */     GBox b = (GBox)text;
/* 142 */     b.title(UINotifications.¤¤wrong);
/* 143 */     b.text(UINotifications.¤¤wrongD).NL();
/* 144 */     for (CAUSE_LEAVE c : this.wrongful) {
/* 145 */       b.textL(c.name);
/* 146 */       b.tab(6);
/* 147 */       b.add((SPRITE)GFORMAT.i(b.text(), (SETT.THINGS()).corpses.amount(c)));
/* 148 */       b.NL();
/*     */     } 
/* 150 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 155 */     if (this.corpse == null || this.corpse.isRemoved() || this.corpse.cause() != this.wrongful.get(this.ci)) {
/* 156 */       this.corpse = getCorpse();
/*     */     }
/* 158 */     if (this.corpse != null) {
/* 159 */       VIEW.s().activate();
/* 160 */       (VIEW.s().getWindow()).centererTile.set(this.corpse.ctx(), this.corpse.cty());
/* 161 */       this.corpse = (SETT.THINGS()).corpses.getNext(this.corpse);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ThingsCorpses.Corpse getCorpse() {
/* 166 */     for (int i = 0; i < this.wrongful.size(); i++) {
/* 167 */       this.ci++;
/* 168 */       this.ci %= this.wrongful.size();
/* 169 */       ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getFirst((CAUSE_LEAVE)this.wrongful.get(this.ci));
/* 170 */       if (c != null) {
/* 171 */         return c;
/*     */       }
/*     */     } 
/* 174 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UINotifications$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */