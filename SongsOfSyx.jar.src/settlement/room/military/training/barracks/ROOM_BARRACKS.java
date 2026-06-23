/*    */ package settlement.room.military.training.barracks;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.military.training.ROOM_M_TRAINER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ public final class ROOM_BARRACKS
/*    */   extends ROOM_M_TRAINER<BarracksInstance>
/*    */ {
/*    */   final Constructor constructor;
/* 13 */   final BarracksThing thing = new BarracksThing(this);
/*    */   
/*    */   public ROOM_BARRACKS(int typeIndex, RoomInitData data, String key) throws IOException {
/* 16 */     super(typeIndex, data, key);
/*    */     
/* 18 */     this.constructor = new Constructor(this, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 23 */     return this.constructor;
/*    */   }
/*    */   
/*    */   public COORDINATE faceCoo(int tx, int ty) {
/* 27 */     return (COORDINATE)(this.thing.init(tx, ty)).cooMan;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\barracks\ROOM_BARRACKS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */