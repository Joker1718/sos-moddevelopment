/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
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
/*     */ public final class StatEducation
/*     */ {
/* 239 */   private double dAmount = 0.0D;
/*     */   
/*     */   private final STAT[] allT;
/*     */   private final int index;
/*     */   public STAT total;
/*     */   
/*     */   StatEducation(String key, StatsInit init, SPRITE icon, int index) {
/* 246 */     this.allT = new STAT[paramStatsEducation.allAges.size()];
/* 247 */     for (int i = 0; i < this.allT.length; i++) {
/* 248 */       this.allT[i] = (STAT)new STATData(null, key + "DC" + key, init, (INT_O.INT_OE)new DataO.DataByte(init.count, key + "DC" + key, 100));
/* 249 */       init.copier.add(this.allT[i].indu());
/*     */     } 
/*     */     
/* 252 */     this.index = index;
/* 253 */     this.total = (STAT)new STATFake(key, init)
/*     */       {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack)
/*     */         {
/* 257 */           double res = 0.0D; byte b; int i; STAT[] arrayOfSTAT;
/* 258 */           for (i = (arrayOfSTAT = StatsEducation.StatEducation.this.allT).length, b = 0; b < i; ) { STAT t = arrayOfSTAT[b];
/* 259 */             res += t.data(s).getD(r, daysBack); b++; }
/*     */           
/* 261 */           return res / StatsEducation.StatEducation.this.allT.length;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 267 */           GBox b = (GBox)text;
/*     */ 
/*     */           
/* 270 */           for (StatsEducation.AgeType t : (StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this)).allAges) {
/* 271 */             b.textLL(t.name);
/* 272 */             b.tab(6);
/* 273 */             b.add((SPRITE)GFORMAT.perc(b.text(), StatsEducation.StatEducation.this.allT[t.typeI].data(cl).getD(type)));
/* 274 */             b.NL();
/* 275 */             b.textL(StatsEducation.¤¤currentLimit);
/* 276 */             b.tab(6);
/* 277 */             b.add((SPRITE)GFORMAT.perc(b.text(), t.limit(cl, type) / 100.0D));
/* 278 */             b.NL();
/* 279 */             b.textL(StatsEducation.¤¤currentLimitSpeed);
/* 280 */             b.tab(6);
/* 281 */             b.add((SPRITE)GFORMAT.f1(b.text(), t.limitSpeed(cl, type) / 100.0D, 2.0D));
/* 282 */             b.sep();
/*     */           } 
/*     */           
/* 285 */           b.textLL(Dic.¤¤Total);
/* 286 */           b.tab(6);
/* 287 */           b.add((SPRITE)GFORMAT.perc(b.text(), getDD(cl, type, 0)));
/* 288 */           b.sep();
/* 289 */           super.hover(text, cl, type);
/*     */         }
/*     */ 
/*     */         
/*     */         protected double induGet(Induvidual i) {
/* 294 */           double res = 0.0D; byte b; int j;
/*     */           STAT[] arrayOfSTAT;
/* 296 */           for (j = (arrayOfSTAT = StatsEducation.StatEducation.this.allT).length, b = 0; b < j; ) { STAT t = arrayOfSTAT[b];
/*     */             
/* 298 */             res += t.indu().getD(i);
/*     */             b++; }
/*     */           
/* 301 */           return res / StatsEducation.StatEducation.this.allT.length;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, Induvidual indu) {
/* 306 */           GBox b = (GBox)text;
/* 307 */           b.textLL(StatsEducation.¤¤currentPolicy);
/* 308 */           b.tab(6);
/* 309 */           b.add((SPRITE)b.text().add(((StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this).policy(indu.clas(), indu.race())).total.info()).name));
/* 310 */           b.NL();
/*     */           
/* 312 */           for (StatsEducation.AgeType t : (StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this)).allAges) {
/* 313 */             b.textLL(t.name);
/* 314 */             b.tab(6);
/* 315 */             b.add((SPRITE)GFORMAT.perc(b.text(), StatsEducation.StatEducation.this.allT[t.typeI].indu().getD(indu)));
/* 316 */             b.NL();
/*     */           } 
/*     */           
/* 319 */           super.hover(text, indu);
/*     */         }
/*     */       };
/* 322 */     (this.total.info()).icon = icon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void educate(Induvidual i, double amount, STAT toIncrease) {
/* 328 */     double dam = amount + this.dAmount;
/*     */     
/* 330 */     int am = (int)dam;
/* 331 */     this.dAmount = dam - am;
/* 332 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 335 */     am = decrease(i, am);
/*     */     
/* 337 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 340 */     int max = toIncrease.indu().max(i) - toIncrease.indu().get(i);
/* 341 */     if (am > max) {
/* 342 */       this.dAmount += (am - max);
/* 343 */       am = max;
/*     */     } 
/* 345 */     toIncrease.indu().inc(i, am);
/*     */   }
/*     */   
/*     */   private int decrease(Induvidual i, int am) {
/* 349 */     if (am == 0) {
/* 350 */       return am;
/*     */     }
/* 352 */     for (StatEducation o : StatsEducation.this.all) {
/* 353 */       if (o == this)
/*     */         continue;  byte b; int j;
/*     */       STAT[] arrayOfSTAT;
/* 356 */       for (j = (arrayOfSTAT = o.allT).length, b = 0; b < j; ) { STAT os = arrayOfSTAT[b];
/* 357 */         int a = os.indu().get(i);
/* 358 */         if (am > a) {
/* 359 */           os.indu().inc(i, -a);
/* 360 */           am -= a;
/*     */         } else {
/* 362 */           os.indu().inc(i, -am);
/* 363 */           return 0;
/*     */         } 
/* 365 */         if (am <= 0)
/* 366 */           return 0; 
/*     */         b++; }
/*     */     
/*     */     } 
/* 370 */     return am;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEducation$StatEducation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */