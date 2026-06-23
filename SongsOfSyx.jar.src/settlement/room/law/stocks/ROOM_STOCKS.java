/*     */ package settlement.room.law.stocks;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_STOCKS extends RoomBlueprintIns<Instance> implements ROOM_SPECTATOR.ROOM_SPECTATOR_HASER, PUNISHMENT_SERVICE {
/*     */   final MConstructor constructor;
/*  36 */   final Tile tile = new Tile(this); public final RoomServiceNeed data;
/*     */   int used;
/*     */   int total;
/*     */   private final ROOM_SPECTATOR activity;
/*     */   private Coo tmp;
/*     */   
/*  42 */   public ROOM_STOCKS(RoomInitData init, RoomCategorySub cat) throws IOException { super(0, init, "_STOCKS", cat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     this.activity = new ROOM_SPECTATOR()
/*     */       {
/*     */         
/*     */         public boolean shouldBoo(int sx, int sy)
/*     */         {
/* 125 */           Tile t = ROOM_STOCKS.this.tile.get(sx, sy);
/* 126 */           if (t != null && t.state() == Tile.STATE.used)
/* 127 */             return true; 
/* 128 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isActive(int sx, int sy) {
/* 133 */           Tile t = ROOM_STOCKS.this.tile.get(sx, sy);
/* 134 */           if (t != null && t.state() == Tile.STATE.used)
/* 135 */             return true; 
/* 136 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldCheer(int sx, int sy) {
/* 141 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public RoomServiceAccess service() {
/* 146 */           return (RoomServiceAccess)ROOM_STOCKS.this.data;
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
/* 173 */     this.tmp = new Coo(); this.constructor = new MConstructor(this, init); this.data = new RoomServiceNeed((RoomBlueprintImp)this, init) { public FSERVICE service(int tx, int ty) { Tile t = ROOM_STOCKS.this.tile.get(tx, ty); if (t != null) return t.service;  return null; } }
/*     */       ; } public void appendView(LISTE<UIRoomModule> mm) { mm.add(new UIRoomModule() {
/*     */           public void hover(GBox box, Room i, int rx, int ry) { AREA a = (AREA)(SETT.ROOMS()).map.rooma.get(rx, ry); int am = 0; int aa = 0; for (COORDINATE c : a.body()) { if (a.is(c) && ROOM_STOCKS.this.tile.get(c.x(), c.y()) != null) { am++; if (ROOM_STOCKS.this.tile.get(c.x(), c.y()).state() == Tile.STATE.available) aa++;  }  }  box.textLL(Dic.¤¤Available); box.add((SPRITE)GFORMAT.iofk(box.text(), aa, am)); super.hover(box, i, rx, ry); }
/* 176 */         }); } protected void saveP(FilePutter f) { f.i(this.used); f.i(this.total); } protected void loadP(FileGetter f) throws IOException { this.used = f.i(); this.total = f.i(); } protected void clearP() { this.used = 0; this.total = 0; } protected void update(double ds) {} public COORDINATE stockReserve() { if (this.used >= this.total) {
/* 177 */       return null;
/*     */     }
/* 179 */     int am = instancesSize();
/* 180 */     if (am == 0)
/* 181 */       return null; 
/* 182 */     int ri = RND.rInt(am);
/*     */     
/*     */     int i;
/* 185 */     for (i = 0; i < am; i++) {
/*     */       
/* 187 */       Instance ins = (Instance)getInstance((ri + i) % am);
/* 188 */       if (ins.available > 0) {
/*     */ 
/*     */         
/* 191 */         Iterator<COORDINATE> iterator = ins.body().iterator(); if (iterator.hasNext()) { COORDINATE c = iterator.next();
/* 192 */           Tile t = this.tile.get(c.x(), c.y());
/* 193 */           if (t != null && t.state() == Tile.STATE.available) {
/* 194 */             t.stateSet(Tile.STATE.reserved);
/* 195 */             this.tmp.set(c);
/* 196 */             return (COORDINATE)this.tmp;
/*     */           } 
/* 198 */           LOG.err("nono"); }
/*     */       
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 205 */     for (i = 0; i < am; i++) {
/*     */       
/* 207 */       Instance ins = (Instance)getInstance(i);
/*     */ 
/*     */       
/* 210 */       for (COORDINATE c : ins.body()) {
/* 211 */         Tile t = this.tile.get(c.x(), c.y());
/* 212 */         if (t != null) {
/* 213 */           t.stateSet(Tile.STATE.none);
/*     */         }
/*     */       } 
/*     */       
/* 217 */       ins.available = 0;
/*     */     } 
/*     */ 
/*     */     
/* 221 */     this.used = 0;
/* 222 */     this.total = 0;
/*     */     
/* 224 */     for (i = 0; i < am; i++) {
/*     */       
/* 226 */       Instance ins = (Instance)getInstance(i);
/*     */ 
/*     */       
/* 229 */       for (COORDINATE c : ins.body()) {
/* 230 */         Tile t = this.tile.get(c.x(), c.y());
/* 231 */         if (t != null) {
/* 232 */           t.stateSet(Tile.STATE.available);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 237 */     return null; }
/*     */   public SFinderRoomService service(int tx, int ty) { return this.data.finder; }
/*     */   public MConstructor constructor() { return this.constructor; }
/*     */   public ROOM_SPECTATOR spec() { return this.activity; }
/* 241 */   public DIR stockDir(int tx, int ty, DIR d) { FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty); if (it == null) return d;  if ((GUTIL.ran2().get(tx, ty) & 0x1) == 0) return (DIR)DIR.ORTHO.getC(it.rotation - 1);  return (DIR)DIR.ORTHO.getC(it.rotation + 1); } public boolean stockIsReserved(int tx, int ty) { Tile t = this.tile.get(tx, ty); if (t != null) return !(t.state() != Tile.STATE.reserved && t.state() != Tile.STATE.used);  return this.constructor.service(tx, ty); } public void stockUse(int tx, int ty) { Tile t = this.tile.get(tx, ty);
/* 242 */     if (t != null && t.state() == Tile.STATE.reserved) {
/* 243 */       t.stateSet(Tile.STATE.used);
/*     */     } }
/*     */ 
/*     */   
/*     */   public void stockCancel(int tx, int ty) {
/* 248 */     Tile t = this.tile.get(tx, ty);
/* 249 */     if (t != null) {
/* 250 */       t.stateSet(Tile.STATE.available);
/*     */     }
/*     */   }
/*     */   
/*     */   public RoomServiceNeed service() {
/* 255 */     return this.data;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int punishTotal() {
/* 261 */     return this.total;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int punishUsed() {
/* 267 */     return this.used;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stocks\ROOM_STOCKS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */