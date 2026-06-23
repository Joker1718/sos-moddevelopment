/*     */ package settlement.room.service.arena.grand;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.arena.RoomArenaGui;
/*     */ import settlement.room.service.arena.RoomArenaWork;
/*     */ import settlement.room.service.arena.pit.ROOM_FIGHTPIT;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_ARENA
/*     */   extends RoomBlueprintIns<ArenaInstance>
/*     */   implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, ROOM_SPECTATOR.ROOM_SPECTATOR_HASER, PUNISHMENT_SERVICE {
/*     */   final RoomServiceNeed data;
/*     */   final Service ser;
/*     */   final ArenaConstructor constructor;
/*  41 */   int executions = 0;
/*  42 */   int executionsMax = 0;
/*  43 */   private final BOOLEANO.BooleanOEImp<Race> permission = new BOOLEANO.BooleanOEImp(RACES.all().size(), true);
/*     */   
/*     */   public ROOM_ARENA(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  46 */     super(index, init, key, block);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     this.spec = new ROOM_SPECTATOR()
/*     */       {
/* 134 */         private Coo coo = new Coo();
/*     */ 
/*     */         
/*     */         public RoomServiceAccess service() {
/* 138 */           return (RoomServiceAccess)ROOM_ARENA.this.service();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public COORDINATE lookAt(int sx, int sy) {
/* 145 */           ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(sx, sy);
/* 146 */           if (ins == null) {
/* 147 */             this.coo.set(sx, sy);
/*     */           } else {
/* 149 */             this.coo.set(sx, sy);
/* 150 */             RECTANGLE rec = ROOM_ARENA.this.work.gladiatorArea(sx, sy);
/* 151 */             int w = Math.min(4, rec.width());
/* 152 */             int h = Math.min(4, rec.height());
/* 153 */             int a = w * h;
/* 154 */             int i = (sx + sy) % a;
/* 155 */             this.coo.set((rec.cX() - w / 2 + i % w), (rec.cY() - h / 2 + i / h));
/*     */           } 
/* 157 */           this.coo.set((this.coo.x() * 64 + 32), (this.coo.y() * 64 + 32));
/* 158 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int sx, int sy) {
/* 163 */           ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(sx, sy);
/* 164 */           return (ins != null);
/*     */         }
/*     */         
/*     */         private int activity(int sx, int sy) {
/* 168 */           ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(sx, sy);
/* 169 */           if (ins == null) {
/* 170 */             return 0;
/*     */           }
/* 172 */           int d = (int)TIME.currentSecond() - ins.cheerTime;
/*     */           
/* 174 */           if (d > ArenaInstance.CHEER_TIME * 8) {
/* 175 */             ins.cheerTime = (int)TIME.currentSecond();
/* 176 */             ins.cheer = false;
/* 177 */             d = 0;
/*     */           } 
/*     */           
/* 180 */           if (d <= ArenaInstance.CHEER_TIME) {
/* 181 */             if (ins.cheer)
/* 182 */               return 1; 
/* 183 */             return 2;
/*     */           } 
/*     */           
/* 186 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isActive(int sx, int sy) {
/* 191 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldCheer(int sx, int sy) {
/* 196 */           return (activity(sx, sy) == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldBoo(int sx, int sy) {
/* 201 */           return (activity(sx, sy) == 2);
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE getDestination(COORDINATE roomT) {
/* 206 */           this.coo.set(roomT.x(), roomT.y());
/* 207 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isSpot(int tx, int ty) {
/* 212 */           if (ROOM_ARENA.this.ser.init(tx, ty))
/* 213 */             return true; 
/* 214 */           return super.isSpot(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isOpenNow() {
/* 219 */           return !(TIME.hours().bitCurrent() <= 11 && TIME.hours().bitCurrent() >= 6);
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
/* 230 */     this.work = new RoomArenaWork()
/*     */       {
/* 232 */         private Coo coo = new Coo();
/*     */ 
/*     */         
/*     */         public boolean gladiatorInArena(int tx, int ty) {
/* 236 */           ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(tx, ty);
/* 237 */           if (ins != null) {
/* 238 */             return ins.arena.holdsPoint(tx, ty);
/*     */           }
/* 240 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE gladiatorGetSpot(RoomInstance ins) {
/* 245 */           ArenaInstance a = (ArenaInstance)ins;
/* 246 */           int w = a.arena.width();
/* 247 */           int h = a.arena.height();
/* 248 */           this.coo.set((a.arena.x1() + RND.rInt(w)), (a.arena.y1() + RND.rInt(h)));
/* 249 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void gladiatorDrawMakeSheer(COORDINATE coo) {
/* 255 */           ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(coo);
/* 256 */           if (ins != null) {
/* 257 */             ins.cheerTime = (int)TIME.currentSecond();
/* 258 */             ins.cheer = !RND.oneIn(6);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public RECTANGLE gladiatorArea(int tx, int ty) {
/* 264 */           ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(tx, ty);
/* 265 */           if (ins != null) {
/* 266 */             return ins.arena;
/*     */           }
/* 268 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RoomInstance reserveDeath(COORDINATE coo) {
/* 273 */           if (ROOM_ARENA.this.executions >= ROOM_ARENA.this.executionsMax || ROOM_ARENA.this.instancesSize() <= 0) {
/* 274 */             return null;
/*     */           }
/*     */           
/* 277 */           ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(coo);
/* 278 */           if (ins != null && ins.executions < 4) {
/* 279 */             ins.executions = (byte)(ins.executions + 1);
/* 280 */             ROOM_ARENA.this.executions++;
/* 281 */             return ins;
/*     */           } 
/*     */           
/* 284 */           int ri = RND.rInt(ROOM_ARENA.this.instancesSize());
/*     */           
/* 286 */           for (int i = 0; i < ROOM_ARENA.this.instancesSize(); i++) {
/* 287 */             ArenaInstance arenaInstance = (ArenaInstance)ROOM_ARENA.this.getInstance((i + ri) % ROOM_ARENA.this.instancesSize());
/* 288 */             if (arenaInstance.active() && arenaInstance.employees().employed() > 0 && arenaInstance.executions < 4) {
/* 289 */               arenaInstance.executions = (byte)(arenaInstance.executions + 1);
/* 290 */               ROOM_ARENA.this.executions++;
/* 291 */               return arenaInstance;
/*     */             } 
/*     */           } 
/* 294 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void unreserveDeath(int tx, int ty) {
/* 299 */           ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(tx, ty);
/* 300 */           if (ins != null) {
/* 301 */             ins.executions = (byte)(ins.executions - 1);
/* 302 */             ins.executions = (byte)Math.max(ins.executions, 0);
/* 303 */             if (ins.active() && ins.employees().employed() > 0) {
/* 304 */               ROOM_ARENA.this.executions--;
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public int executions() {
/* 311 */           return ROOM_ARENA.this.executions;
/*     */         }
/*     */ 
/*     */         
/*     */         public int executionsMax() {
/* 316 */           return ROOM_ARENA.this.executionsMax;
/*     */         }
/*     */ 
/*     */         
/*     */         public int executions(RoomInstance ins) {
/* 321 */           if (ins instanceof ArenaInstance) {
/* 322 */             ArenaInstance i = (ArenaInstance)ins;
/* 323 */             return i.executions;
/*     */           } 
/* 325 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int executionsMax(RoomInstance ins) {
/* 330 */           return 4;
/*     */         }
/*     */       };
/*     */     this.constructor = new ArenaConstructor(this, init);
/*     */     this.ser = new Service(this);
/*     */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init) {
/*     */         public FSERVICE service(int tx, int ty) {
/*     */           return ROOM_ARENA.this.ser.get(tx, ty);
/*     */         }
/*     */         
/*     */         public boolean isGoodTime() {
/*     */           return ROOM_ARENA.this.spec.isOpenNow();
/*     */         }
/*     */       };
/*     */     employment().setShiftStart(ROOM_SPECTATOR.WORK_STARTSD, false);
/*     */     this.permission.info = new INFO(ROOM_FIGHTPIT.¤¤kill, ROOM_FIGHTPIT.¤¤killD);
/*     */   }
/*     */   private final ROOM_SPECTATOR spec;
/*     */   public final RoomArenaWork work;
/*     */   
/*     */   protected void update(double ds) {}
/*     */   
/*     */   public Furnisher constructor() {
/*     */     return this.constructor;
/*     */   }
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*     */     return this.data.finder;
/*     */   }
/*     */   
/*     */   protected void saveP(FilePutter f) {
/*     */     this.data.saver.save(f);
/*     */     f.i(this.executions);
/*     */     f.i(this.executionsMax);
/*     */     this.permission.save(f);
/*     */   }
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {
/*     */     this.data.saver.load(f);
/*     */     this.executions = f.i();
/*     */     this.executionsMax = f.i();
/*     */     this.permission.load(f);
/*     */   }
/*     */   
/*     */   protected void clearP() {
/*     */     this.data.saver.clear();
/*     */     this.executions = 0;
/*     */     this.executionsMax = 0;
/*     */     this.permission.clear();
/*     */   }
/*     */   
/*     */   public int punishTotal() {
/*     */     return this.executionsMax;
/*     */   }
/*     */   
/*     */   public int punishUsed() {
/*     */     return this.executions;
/*     */   }
/*     */   
/*     */   public BOOLEANO.BOOLEAN_OE<Race> punishEnabled() {
/*     */     return (BOOLEANO.BOOLEAN_OE<Race>)this.permission;
/*     */   }
/*     */   
/*     */   public RoomServiceNeed service() {
/*     */     return this.data;
/*     */   }
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*     */     mm.add(new RoomArenaGui(this.work));
/*     */   }
/*     */   
/*     */   public ROOM_SPECTATOR spec() {
/*     */     return this.spec;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\ROOM_ARENA.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */