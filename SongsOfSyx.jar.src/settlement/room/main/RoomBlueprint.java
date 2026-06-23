/*    */ package settlement.room.main;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.room.main.employment.RoomEmploymentSimple;
/*    */ import settlement.thing.pointlight.LOS;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.map.MAP_OBJECT;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.keymap.MAPPED;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class RoomBlueprint
/*    */   extends ROOMS.RoomResource
/*    */   implements MAP_OBJECT<Room>, MAPPED
/*    */ {
/*    */   private final int index;
/* 25 */   static ArrayListGrower<RoomBlueprint> ALL = new ArrayListGrower();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String key;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected RoomBlueprint(String key) {
/* 38 */     this.index = ALL.add(this);
/* 39 */     this.key = key;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Room get(int tx, int ty) {
/* 46 */     if (SETT.IN_BOUNDS(tx, ty))
/* 47 */       return get(tx + ty * SETT.TWIDTH); 
/* 48 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Room get(int tile) {
/* 53 */     Room r = (SETT.ROOMS()).map.get(tile);
/* 54 */     if (r != null && r.blueprint() == this)
/* 55 */       return r; 
/* 56 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int index() {
/* 61 */     return this.index;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean makesDudesDirty() {
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {}
/*    */ 
/*    */   
/*    */   public double strength(int tile) {
/* 80 */     return 25600.0D;
/*    */   }
/*    */   
/*    */   public LOS LOS(int tx, int ty) {
/* 84 */     return SETT.TILE_MAP().LOS(tx, ty);
/*    */   }
/*    */   
/*    */   public RoomEmploymentSimple employment() {
/* 88 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 93 */     return this.key;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean registersEnvironment() {
/* 99 */     return false;
/*    */   }
/*    */   
/*    */   public abstract SFinderFindable service(int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract COLOR miniC(int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract COLOR miniCPimped(ColorImp paramColorImp, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomBlueprint.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */