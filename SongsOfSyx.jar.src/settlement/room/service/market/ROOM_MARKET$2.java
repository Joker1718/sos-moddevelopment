/*    */ package settlement.room.service.market;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.race.RaceResources;
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.service.food.eatery.RoomDistribution;
/*    */ import settlement.room.service.module.RoomServiceAccess;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 60 */     ArrayListGrower<RESOURCE> ress = new ArrayListGrower();
/* 61 */     RBIT.RBITImp bits = new RBIT.RBITImp();
/*    */     
/* 63 */     for (RaceResources.RaceResource r : (RACES.res()).ALL) {
/* 64 */       ress.add(r.res);
/* 65 */       bits.or(r.res.bit);
/*    */     } 
/*    */     
/* 68 */     ROOM_MARKET.this.dist = new RoomDistribution(ROOM_MARKET.this, ROOM_MARKET.this, (LIST)ress, bits, 1)
/*    */       {
/*    */         protected boolean isPref(RESOURCE r, Race race)
/*    */         {
/* 72 */           return false;
/*    */         }
/*    */ 
/*    */         
/*    */         protected boolean isDeposit(int tx, int ty) {
/* 77 */           return (ROOM_MARKET.null.access$0(ROOM_MARKET.null.this)).constructor.isStore(tx, ty);
/*    */         }
/*    */ 
/*    */         
/*    */         protected boolean isCrate(int tx, int ty) {
/* 82 */           return (ROOM_MARKET.null.access$0(ROOM_MARKET.null.this)).constructor.isCrate(tx, ty);
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\market\ROOM_MARKET$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */