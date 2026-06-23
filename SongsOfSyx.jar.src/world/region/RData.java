/*    */ package world.region;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public class RData
/*    */   implements INT_O<Region> {
/*    */   public final CharSequence name;
/*    */   
/*    */   public RData(String key, INT_O.INT_OE<Region> plocal, RD.RDInit init, CharSequence name) {
/* 13 */     this.name = name;
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
/* 30 */     this.plocal = plocal;
/* 31 */     init.rCount.getClass(); this.ftotal = (INT_O.INT_OE<Faction>)new DataO.DataInt(init.rCount, key);
/*    */   }
/*    */ 
/*    */   
/*    */   protected final INT_O.INT_OE<Region> plocal;
/*    */   
/*    */   protected final INT_O.INT_OE<Faction> ftotal;
/*    */   
/*    */   public int get(Region t) {
/* 40 */     return this.plocal.get(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(Region t) {
/* 45 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Region t) {
/* 50 */     return this.plocal.max(t);
/*    */   }
/*    */   
/*    */   public INT_O<Faction> faction() {
/* 54 */     return (INT_O<Faction>)this.ftotal;
/*    */   }
/*    */   
/*    */   public static class RDataE
/*    */     extends RData implements INT_O.INT_OE<Region> {
/*    */     public RDataE(String key, INT_O.INT_OE<Region> plocal, RD.RDInit init, CharSequence name) {
/* 60 */       super(key, plocal, init, name);
/*    */     }
/*    */ 
/*    */     
/*    */     public void set(Region t, int i) {
/* 65 */       if (i != get(t)) {
/* 66 */         if (t.faction() != null) {
/* 67 */           this.ftotal.inc(t.faction(), -this.plocal.get(t));
/*    */         }
/* 69 */         this.plocal.set(t, i);
/* 70 */         if (t.faction() != null)
/* 71 */           this.ftotal.inc(t.faction(), this.plocal.get(t)); 
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */