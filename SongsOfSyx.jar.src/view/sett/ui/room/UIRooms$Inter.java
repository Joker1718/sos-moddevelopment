/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.service.module.RoomFinderHaser;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
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
/*     */ final class Inter
/*     */   extends Interrupter
/*     */ {
/*     */   Room room;
/*     */   int tx;
/*     */   int ty;
/*     */   
/*     */   protected boolean update(float ds) {
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 182 */     if (this.room.blueprint() instanceof ROOM_MONUMENT) {
/* 183 */       SETT.OVERLAY().monument((ROOM_MONUMENT)this.room.blueprint());
/* 184 */     } else if (this.room.blueprint() instanceof RoomFinderHaser) {
/* 185 */       SETT.OVERLAY().service((RoomFinderHaser)this.room.blueprint());
/*     */     } else {
/* 187 */       for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) {
/* 188 */         if (this.room.constructor().envValue(e)) {
/* 189 */           SETT.OVERLAY().envThing(e).add();
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 194 */     SETT.OVERLAY().add(this.tx, this.ty);
/*     */     
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void show(Room room, int tx, int ty) {
/* 201 */     if (!has(room))
/*     */       return; 
/* 203 */     this.room = room;
/* 204 */     this.tx = tx;
/* 205 */     this.ty = ty;
/*     */     
/* 207 */     show((VIEW.s()).uiManager);
/*     */   }
/*     */   
/*     */   private boolean has(Room room) {
/* 211 */     if (room.blueprint() instanceof ROOM_MONUMENT) {
/* 212 */       return true;
/*     */     }
/* 214 */     if (room.blueprint() instanceof RoomFinderHaser) {
/* 215 */       return true;
/*     */     }
/* 217 */     for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) {
/* 218 */       if (room.constructor().envValue(e)) {
/* 219 */         return true;
/*     */       }
/*     */     } 
/* 222 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 227 */     if (button == MButt.RIGHT) {
/* 228 */       hide();
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean otherClick(MButt button) {
/* 233 */     if (button != MButt.WHEEL_SPIN)
/* 234 */       hide(); 
/* 235 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hide() {
/* 240 */     super.hide();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 251 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRooms$Inter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */