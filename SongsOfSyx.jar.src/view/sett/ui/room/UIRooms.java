/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.gate.ROOM_GATE;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import settlement.room.service.module.RoomFinderHaser;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ public final class UIRooms
/*     */ {
/*  36 */   final UIRoom[] rooms = new UIRoom[SETT.ROOMS().all().size()];
/*     */   
/*     */   private UIPanelMain main;
/*  39 */   private final GuiSection pop2 = new GuiSection();
/*  40 */   private static CharSequence ¤¤reconstructPrompt = "¤Do you wish to refurnish this room? Some progress of the current construction will be lost."; final Coo rRoom; private ACTION recon; private final Inter inter;
/*     */   static {
/*  42 */     D.ts(UIRooms.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISidePanel main() {
/*  88 */     return this.main;
/*     */   }
/*     */   
/*     */   public void hover(GBox box, Room r, int rx, int ry) {
/*  92 */     this.rooms[r.blueprint().index()].hover(box, r, rx, ry);
/*     */   }
/*     */   
/*     */   public boolean problem(Room r, int rx, int ry) {
/*  96 */     return this.rooms[r.blueprint().index()].problem(r, rx, ry);
/*     */   }
/*     */   
/*     */   public boolean warning(Room r, int rx, int ry) {
/* 100 */     return this.rooms[r.blueprint().index()].warning(r, rx, ry);
/*     */   }
/*     */   
/*     */   public void open(RoomEquip w) {
/* 104 */     this.main.open(w);
/*     */   }
/*     */   
/* 107 */   public UIRooms() { this.rRoom = new Coo();
/*     */     
/* 109 */     this.recon = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 113 */           (VIEW.s()).ui.placer.reconstruct(UIRooms.this.rRoom.x(), UIRooms.this.rRoom.y());
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     this.inter = new Inter(); Init init = new Init(); Modules mm = new Modules(init); D.t(UIRoom.class); for (RoomBlueprint p : SETT.ROOMS().all()) this.rooms[p.index()] = new UIRoom(p, mm.get(p));  this.main = new UIPanelMain(this.rooms); SETT.addGeneratorHook(new ACTION() {
/*     */           public void exe() { UIRooms.this.main = new UIPanelMain(UIRooms.this.rooms); }
/*     */         }); for (int i = 0; i < RACES.all().size(); i++) { final Race r = (Race)RACES.all().get(i); CLICKABLE c = (new GButt.ButtPanel((r.appearance()).iconBig.big) {
/*     */           protected void clickA() { (VIEW.inters()).popup.close(); UIRooms.this.main.work.set(r, HTYPES.SLAVE()); (VIEW.s()).panels.add((ISidePanel)UIRooms.this.main.work, true); }
/*     */         }).hoverInfoSet(r.info.names); c.body().moveX1Y1((i % 5 * c.body().width()), (i / 5 * c.body().height())); this.pop2.add((RENDEROBJ)c); }  }
/*     */   public void click(Room room, int tx, int ty) { if (room.blueprint() instanceof ROOM_GATE) { ((ROOM_GATE)room.blueprint()).lock(tx, ty, !((ROOM_GATE)room.blueprint()).locked(tx, ty)); } else if (room.blueprint() == (SETT.ROOMS()).HOME) { (VIEW.s()).panels.add((ISidePanel)(VIEW.s()).ui.home, true); } else if (room.blueprint() == (SETT.ROOMS()).THRONE) { (VIEW.UI()).level.activate(); } else if (room instanceof RoomInstance) { open((RoomInstance)room); } else if ((SETT.ROOMS()).placement.canReconstruct(tx, ty)) { this.rRoom.set(tx, ty); (VIEW.inters()).yesNo.activate(¤¤reconstructPrompt, this.recon, ACTION.NOP, true); } else if ((this.rooms[room.blueprint().index()]).table == null) { this.inter.show(room, tx, ty); } else if (room instanceof RoomInstance) { open((RoomInstance)room); }  } public void open(RoomInstance r) { if ((this.rooms[r.blueprint().index()]).table == null) return;  (VIEW.s()).panels.add((this.rooms[r.blueprint().index()]).table.get(), true); (VIEW.s()).panels.add(this.rooms[r.blueprint().index()].detail(r), false); } public ISidePanel open(RoomBlueprint r) { if ((this.rooms[r.index()]).table == null)
/*     */       return null;  return (this.rooms[r.index()]).table.get(); } public boolean openIs(RoomBlueprint r) { if ((this.rooms[r.index()]).table == null)
/*     */       return false;  return ((VIEW.s()).panels.added((this.rooms[r.index()]).table) && (VIEW.s()).panels.added((this.rooms[r.index()]).detail)); } public void prio(HCLASS c, Race r, CLICKABLE trigger) { if (c == HCLASSES.SLAVE()) { (VIEW.inters()).popup.show((RENDEROBJ)this.pop2, trigger); } else if (c == HCLASSES.CITIZEN() && r != null) { this.main.work.set(r, HTYPES.SUBJECT()); (VIEW.s()).panels.add((ISidePanel)this.main.work, true); } else { (VIEW.s()).panels.add((ISidePanel)this.main.work, true); }  } private final class Inter extends Interrupter
/*     */   {
/* 177 */     Room room; protected boolean update(float ds) { return true; }
/*     */     
/*     */     int tx; int ty;
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 182 */       if (this.room.blueprint() instanceof ROOM_MONUMENT) {
/* 183 */         SETT.OVERLAY().monument((ROOM_MONUMENT)this.room.blueprint());
/* 184 */       } else if (this.room.blueprint() instanceof RoomFinderHaser) {
/* 185 */         SETT.OVERLAY().service((RoomFinderHaser)this.room.blueprint());
/*     */       } else {
/* 187 */         for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) {
/* 188 */           if (this.room.constructor().envValue(e)) {
/* 189 */             SETT.OVERLAY().envThing(e).add();
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 194 */       SETT.OVERLAY().add(this.tx, this.ty);
/*     */       
/* 196 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void show(Room room, int tx, int ty) {
/* 201 */       if (!has(room))
/*     */         return; 
/* 203 */       this.room = room;
/* 204 */       this.tx = tx;
/* 205 */       this.ty = ty;
/*     */       
/* 207 */       show((VIEW.s()).uiManager);
/*     */     }
/*     */     
/*     */     private boolean has(Room room) {
/* 211 */       if (room.blueprint() instanceof ROOM_MONUMENT) {
/* 212 */         return true;
/*     */       }
/* 214 */       if (room.blueprint() instanceof RoomFinderHaser) {
/* 215 */         return true;
/*     */       }
/* 217 */       for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) {
/* 218 */         if (room.constructor().envValue(e)) {
/* 219 */           return true;
/*     */         }
/*     */       } 
/* 222 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 227 */       if (button == MButt.RIGHT) {
/* 228 */         hide();
/*     */       }
/*     */     }
/*     */     
/*     */     protected boolean otherClick(MButt button) {
/* 233 */       if (button != MButt.WHEEL_SPIN)
/* 234 */         hide(); 
/* 235 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void hide() {
/* 240 */       super.hide();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void hoverTimer(GBox text) {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 251 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRooms.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */