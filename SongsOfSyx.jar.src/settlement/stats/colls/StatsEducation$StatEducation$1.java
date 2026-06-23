/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import snake2d.util.gui.GUI_BOX;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends STATFake
/*     */ {
/*     */   null(String $anonymous0, StatsInit $anonymous1) {
/* 253 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected double getDD(HCLASS s, Race r, int daysBack) {
/* 257 */     double res = 0.0D; byte b; int i; STAT[] arrayOfSTAT;
/* 258 */     for (i = (arrayOfSTAT = StatsEducation.StatEducation.this.allT).length, b = 0; b < i; ) { STAT t = arrayOfSTAT[b];
/* 259 */       res += t.data(s).getD(r, daysBack); b++; }
/*     */     
/* 261 */     return res / StatsEducation.StatEducation.this.allT.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 267 */     GBox b = (GBox)text;
/*     */ 
/*     */     
/* 270 */     for (StatsEducation.AgeType t : (StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this)).allAges) {
/* 271 */       b.textLL(t.name);
/* 272 */       b.tab(6);
/* 273 */       b.add((SPRITE)GFORMAT.perc(b.text(), StatsEducation.StatEducation.this.allT[t.typeI].data(cl).getD(type)));
/* 274 */       b.NL();
/* 275 */       b.textL(StatsEducation.¤¤currentLimit);
/* 276 */       b.tab(6);
/* 277 */       b.add((SPRITE)GFORMAT.perc(b.text(), t.limit(cl, type) / 100.0D));
/* 278 */       b.NL();
/* 279 */       b.textL(StatsEducation.¤¤currentLimitSpeed);
/* 280 */       b.tab(6);
/* 281 */       b.add((SPRITE)GFORMAT.f1(b.text(), t.limitSpeed(cl, type) / 100.0D, 2.0D));
/* 282 */       b.sep();
/*     */     } 
/*     */     
/* 285 */     b.textLL(Dic.¤¤Total);
/* 286 */     b.tab(6);
/* 287 */     b.add((SPRITE)GFORMAT.perc(b.text(), getDD(cl, type, 0)));
/* 288 */     b.sep();
/* 289 */     super.hover(text, cl, type);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double induGet(Induvidual i) {
/* 294 */     double res = 0.0D; byte b; int j;
/*     */     STAT[] arrayOfSTAT;
/* 296 */     for (j = (arrayOfSTAT = StatsEducation.StatEducation.this.allT).length, b = 0; b < j; ) { STAT t = arrayOfSTAT[b];
/*     */       
/* 298 */       res += t.indu().getD(i);
/*     */       b++; }
/*     */     
/* 301 */     return res / StatsEducation.StatEducation.this.allT.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, Induvidual indu) {
/* 306 */     GBox b = (GBox)text;
/* 307 */     b.textLL(StatsEducation.¤¤currentPolicy);
/* 308 */     b.tab(6);
/* 309 */     b.add((SPRITE)b.text().add(((StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this).policy(indu.clas(), indu.race())).total.info()).name));
/* 310 */     b.NL();
/*     */     
/* 312 */     for (StatsEducation.AgeType t : (StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this)).allAges) {
/* 313 */       b.textLL(t.name);
/* 314 */       b.tab(6);
/* 315 */       b.add((SPRITE)GFORMAT.perc(b.text(), StatsEducation.StatEducation.this.allT[t.typeI].indu().getD(indu)));
/* 316 */       b.NL();
/*     */     } 
/*     */     
/* 319 */     super.hover(text, indu);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEducation$StatEducation$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */