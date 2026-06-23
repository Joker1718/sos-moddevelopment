/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ class null
/*     */   extends FurnisherStat
/*     */ {
/*     */   null(Furnisher $anonymous0, double $anonymous1) {
/*  85 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(AREA area, double fromItems) {
/*  90 */     double f = 0.0D;
/*  91 */     for (COORDINATE c : area.body()) {
/*  92 */       DIR d; if (!area.is(c))
/*     */         continue; 
/*  94 */       Iterator<DIR> iterator = DIR.ALL.iterator(); do { if (!iterator.hasNext())
/*     */         
/*     */         { 
/*     */ 
/*     */           
/*  99 */           f += Constructor.this.fertility(c.x(), c.y()); break; }  d = iterator.next(); }
/*     */       while (area.is(c, d));
/* 101 */     }  return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText format(GText t, double value) {
/* 106 */     double am = 0.0D;
/*     */     
/* 108 */     for (IndustryResource o : ((Industry)blue.industries().get(0)).outs()) {
/* 109 */       am += o.rate;
/*     */     }
/* 111 */     return GFORMAT.f(t, 0.015625D * value * am, 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\Constructor$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */