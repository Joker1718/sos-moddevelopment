/*    */ package world.region;
/*    */ 
/*    */ import util.data.INT_O;
/*    */ import world.map.regions.Region;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RDataE
/*    */   extends RData
/*    */   implements INT_O.INT_OE<Region>
/*    */ {
/*    */   public RDataE(String key, INT_O.INT_OE<Region> plocal, RD.RDInit init, CharSequence name) {
/* 60 */     super(key, plocal, init, name);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(Region t, int i) {
/* 65 */     if (i != get(t)) {
/* 66 */       if (t.faction() != null) {
/* 67 */         this.ftotal.inc(t.faction(), -this.plocal.get(t));
/*    */       }
/* 69 */       this.plocal.set(t, i);
/* 70 */       if (t.faction() != null)
/* 71 */         this.ftotal.inc(t.faction(), this.plocal.get(t)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RData$RDataE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */