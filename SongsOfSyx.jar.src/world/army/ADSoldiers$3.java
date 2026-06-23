/*    */ package world.army;
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
/*    */ class null
/*    */   implements ADInit.Register
/*    */ {
/*    */   public void register(ADDiv div, int d) {
/* 51 */     ((ADInt.ADIntImp)ADSoldiers.this.current.get(div.race().index())).inc(div.army(), d * div.men());
/* 52 */     ((ADInt.ADIntImp)ADSoldiers.this.target.get(div.race().index())).inc(div.army(), d * div.menTarget());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSoldiers$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */