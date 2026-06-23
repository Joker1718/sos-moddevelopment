/*    */ package world.army;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ public interface ADInt extends INT_O<WArmy> {
/*    */   default int faction(WArmy a) {
/* 10 */     return faction(a.faction());
/*    */   }
/*    */   
/*    */   int faction(Faction paramFaction);
/*    */   
/*    */   public static interface ADIntE
/*    */     extends ADInt, INT_O.INT_OE<WArmy> {}
/*    */   
/*    */   public static class ADIntImp
/*    */     implements ADIntE, ADInit.Countable
/*    */   {
/*    */     private final INT_O.INT_OE<WArmy> a;
/*    */     private final INT_O.INT_OE<Faction> f;
/*    */     
/*    */     public ADIntImp(ADInit init, String key, CharSequence name, CharSequence desc) {
/* 25 */       init.dataA.getClass(); this.a = (INT_O.INT_OE<WArmy>)new DataO.DataInt(init.dataA, key);
/* 26 */       init.dataT.getClass(); this.f = (INT_O.INT_OE<Faction>)new DataO.DataInt(init.dataT, key);
/* 27 */       init.countable.add(this);
/*    */     }
/*    */ 
/*    */     
/*    */     public void set(WArmy t, int i) {
/* 32 */       count(t, -1);
/* 33 */       this.a.set(t, i);
/* 34 */       count(t, 1);
/*    */     }
/*    */ 
/*    */     
/*    */     public int get(WArmy t) {
/* 39 */       return this.a.get(t);
/*    */     }
/*    */ 
/*    */     
/*    */     public int min(WArmy t) {
/* 44 */       return 0;
/*    */     }
/*    */ 
/*    */     
/*    */     public int max(WArmy t) {
/* 49 */       return Integer.MAX_VALUE;
/*    */     }
/*    */ 
/*    */     
/*    */     public int faction(Faction f) {
/* 54 */       return this.f.get(f);
/*    */     }
/*    */ 
/*    */     
/*    */     public void count(WArmy t, int delta) {
/* 59 */       this.f.inc(t.faction(), this.a.get(t) * delta);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADInt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */