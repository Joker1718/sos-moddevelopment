/*     */ package settlement.room.infra.gate;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomSingleton;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Instance
/*     */   extends RoomSingleton
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   Instance(ROOMS m, RoomBlueprint p) {
/* 159 */     super(m, p);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 164 */     return (blueprintI()).instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_GATE blueprintI() {
/* 169 */     return (ROOM_GATE)blueprint();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction(ROOMA a) {
/* 175 */     for (COORDINATE c : a.body()) {
/* 176 */       if (a.is(c) && (SETT.TERRAIN()).TREES.isTree(c.x(), c.y())) {
/* 177 */         (SETT.TERRAIN()).NADA.placeFixed(c.x(), c.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 185 */     if ((SETT.ROOMS()).fData.spriteData2.get(tile) == 1) {
/* 186 */       return AVAILABILITY.ROOM_SOLID;
/*     */     }
/* 188 */     return super.getAvailability(tile);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\gate\ROOM_GATE$Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */