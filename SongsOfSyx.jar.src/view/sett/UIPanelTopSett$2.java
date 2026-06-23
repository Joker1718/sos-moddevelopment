/*     */ package view.sett;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.SettUI;
/*     */ import view.ui.top.UIPanelTopButtL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPanelTopButtL
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 109 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected double valueNext() {
/* 113 */     return value();
/*     */   }
/*     */ 
/*     */   
/*     */   protected double value() {
/* 118 */     double t = STATS.WORK().workforce();
/* 119 */     double e = (SETT.ROOMS()).employment.NEEDED.get();
/* 120 */     if (t == 0.0D)
/* 121 */       return ((e > 0.0D) ? false : true); 
/* 122 */     return CLAMP.d(t / e, 0.0D, 2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getNumber() {
/* 127 */     int t = STATS.WORK().workforce();
/* 128 */     int e = (SETT.ROOMS()).employment.NEEDED.get();
/* 129 */     return t - e;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 134 */     GBox b = (GBox)text;
/*     */     
/* 136 */     b.title(Dic.¤¤Workforce);
/* 137 */     b.text(Dic.¤¤WorkforceD);
/* 138 */     b.NL();
/*     */     
/* 140 */     int e = STATS.WORK().workforce();
/* 141 */     int t = (SETT.ROOMS()).employment.NEEDED.get();
/*     */     
/* 143 */     b.textLL(Dic.¤¤Needed);
/* 144 */     b.tab(7);
/* 145 */     b.add((SPRITE)GFORMAT.i(b.text(), t));
/* 146 */     b.NL();
/*     */     
/* 148 */     b.textLL(Dic.¤¤Employees);
/* 149 */     b.tab(7);
/* 150 */     b.add((SPRITE)GFORMAT.i(b.text(), e));
/* 151 */     b.NL();
/*     */     
/* 153 */     b.textLL(Dic.¤¤Oddjobbers);
/* 154 */     b.tab(7);
/* 155 */     b.add((SPRITE)GFORMAT.i(b.text(), (e - t)));
/* 156 */     b.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isActive() {
/* 162 */     return (STATS.WORK().workforce() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 167 */     selectedSet((ui.rooms.main() != null && (VIEW.s()).panels.added(ui.rooms.main())));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 172 */     if (ui.rooms.main() != null)
/* 173 */       (VIEW.s()).panels.add(ui.rooms.main(), true); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\UIPanelTopSett$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */