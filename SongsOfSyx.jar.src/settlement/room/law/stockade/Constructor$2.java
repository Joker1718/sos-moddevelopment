/*    */ package settlement.room.law.stockade;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherStat;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0, double $anonymous1) {
/* 58 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 63 */     double f = 0.0D;
/* 64 */     for (COORDINATE c : area.body()) {
/* 65 */       DIR d; if (!area.is(c))
/*    */         continue; 
/* 67 */       Iterator<DIR> iterator = DIR.ALL.iterator(); do { if (!iterator.hasNext())
/*    */         
/*    */         { 
/*    */ 
/*    */           
/* 72 */           f++; break; }  d = iterator.next(); }
/*    */       while (area.is(c, d));
/* 74 */     }  return f * 0.25D;
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 79 */     return GFORMAT.f(t, value, 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stockade\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */