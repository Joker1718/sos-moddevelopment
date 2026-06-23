/*     */ package settlement.stats.service;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends STATFakeData
/*     */ {
/*     */   double totChildren;
/*     */   int updateI;
/*     */   
/*     */   null(String $anonymous0, String $anonymous1, StatsInit $anonymous2, StatInfo $anonymous3) {
/*  55 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     this.totChildren = 0.0D;
/*  86 */     this.updateI = -1;
/*     */   } public void hover(GUI_BOX text, HCLASS cl, Race type) { GBox b = (GBox)text; b.NL(); b.textL(StatServiceChild.¤¤children); b.tab(6); b.add((SPRITE)GFORMAT.i(b.text(), (int)children())); b.NL(); b.textL(StatServiceChild.¤¤access); b.tab(6); b.add((SPRITE)GFORMAT.i(b.text(), StatServiceChild.this.blueS.service().total())); b.NL(); b.textL(Dic.¤¤Value); b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.perc(b.text(), getDD(cl, type)));
/*     */     b.NL();
/*  90 */     super.hover(text, cl, type); } protected double getDD(HCLASS cl, Race r) { if (!StatServiceChild.this.permission().is(HCLASS_RACE.clP(r, cl)))
/*  91 */       return 0.0D; 
/*  92 */     double tot = StatServiceChild.this.blueS.service().total();
/*  93 */     if (tot <= 0.0D) {
/*  94 */       return 0.0D;
/*     */     }
/*  96 */     return CLAMP.d(tot / children(), 0.0D, 1.0D); }
/*     */    public void hover(GUI_BOX text, Induvidual indu) {
/*     */     hover(text, indu.clas(), indu.race());
/*     */   } private double children() {
/* 100 */     if (this.updateI != GAME.updateI()) {
/* 101 */       this.updateI = GAME.updateI();
/* 102 */       this.totChildren = 0.0D;
/* 103 */       for (Race ra : RACES.all()) {
/* 104 */         if (StatServiceChild.this.permission().is(HCLASS_RACE.clP(ra, HCLASSES.CITIZEN())))
/* 105 */           this.totChildren += STATS.POP().pop(ra, HTYPES.CHILD()); 
/* 106 */         if (StatServiceChild.this.permission().is(HCLASS_RACE.clP(ra, HCLASSES.SLAVE()))) {
/* 107 */           this.totChildren += STATS.POP().pop(ra, HTYPES.CHILD_SLAVE());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     return this.totChildren;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceChild$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */