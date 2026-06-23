/*    */ package settlement.room.military.training.archery;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.military.training.ROOM_M_TRAINER;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.equip.EquipRange;
/*    */ import settlement.thing.projectiles.Trajectory;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ public final class ROOM_ARCHERY
/*    */   extends ROOM_M_TRAINER<ArcheryInstance>
/*    */ {
/*    */   final Constructor constructor;
/* 21 */   final ArcheryThing thing = new ArcheryThing(this);
/* 22 */   private final Trajectory[] trajs = new Trajectory[4];
/*    */ 
/*    */   
/*    */   public ROOM_ARCHERY(int typeIndex, RoomInitData data, String key) throws IOException {
/* 26 */     super(typeIndex, data, key);
/*    */     
/* 28 */     this.constructor = new Constructor(this, data)
/*    */       {
/*    */         public Room create(TmpArea area, RoomInit init)
/*    */         {
/* 32 */           return (Room)new ArcheryInstance(ROOM_ARCHERY.this, area, init);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean isHeavy() {
/* 37 */           return true;
/*    */         }
/*    */       };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 45 */     double dist = (this.constructor.item(1).height() - 1);
/* 46 */     dist *= 64.0D;
/* 47 */     int i = 0;
/* 48 */     for (DIR d : DIR.ORTHO) {
/* 49 */       Trajectory t = new Trajectory();
/* 50 */       t.calcLow(0, 0, 0, (int)(d.x() * dist), (int)(d.y() * dist), 45.0D, 2560.0D);
/* 51 */       this.trajs[i++] = t;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 58 */     return this.constructor;
/*    */   }
/*    */   
/*    */   public DIR faceCoo(int tx, int ty) {
/* 62 */     FurnisherItem t = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 63 */     if (t != null)
/* 64 */       return (DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty)).rotation); 
/* 65 */     return DIR.C;
/*    */   }
/*    */   
/*    */   public void fireArrow(int tx, int ty, int x, int y) {
/* 69 */     if (is(tx, ty)) {
/* 70 */       FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 71 */       if (it != null) {
/* 72 */         Trajectory t = this.trajs[it.rotation];
/* 73 */         SETT.PROJS().launchDummy(x, y, 0, t, ((EquipRange)STATS.EQUIP().RANGED().get(0)).projectile, 0.0D, null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\archery\ROOM_ARCHERY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */