/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ final class HomeContructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_HOME blue;
/*  26 */   final FurnisherStat occupants = (FurnisherStat)new FurnisherStat.FurnisherStatI(this, 1);
/*     */   
/*  28 */   public final int[][] maxOccupants = new int[][] {
/*  29 */       { 3, 4, 5
/*  30 */       }, { 5, 7, 9
/*  31 */       }, { 10, 14, 18 }
/*     */     };
/*     */   
/*     */   static final int entrance = 2;
/*     */   
/*     */   public final FurnisherItemTile tOpening;
/*     */   public final Sprites sp;
/*     */   public final Floors.Floor flooring;
/*     */   
/*     */   protected HomeContructor(RoomInitData init, ROOM_HOME blue) throws IOException {
/*  41 */     super(init, 3, 1);
/*     */     
/*  43 */     this.flooring = (Floors.Floor)this.floors.get(0);
/*  44 */     this.sp = new Sprites(init.data());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     this.blue = blue;
/*  50 */     FurnisherItemTile ee = new FurnisherItemTile(this, true, this.sp.theDummy, AVAILABILITY.ROOM, false);
/*  51 */     ee.setData(2);
/*  52 */     ee.noWalls = true;
/*  53 */     this.tOpening = ee;
/*  54 */     FurnisherItemTile __ = new FurnisherItemTile(this, false, this.sp.theDummy, AVAILABILITY.ROOM, false);
/*  55 */     __.setData(1);
/*  56 */     FurnisherItemTile xx = new FurnisherItemTile(this, false, this.sp.theDummy, AVAILABILITY.NOT_ACCESSIBLE, false);
/*     */     
/*  58 */     LOG.ln();
/*     */     
/*  60 */     create(new FurnisherItemTile[][] {
/*  61 */           { xx, xx, xx
/*  62 */           }, , { xx, __, xx
/*  63 */           }, , { xx, ee, xx }, 
/*  64 */         }, 9);
/*     */     
/*  66 */     create(new FurnisherItemTile[][] {
/*  67 */           { xx, xx, xx
/*  68 */           }, , { xx, __, xx
/*  69 */           }, , { xx, __, xx
/*  70 */           }, , { xx, __, xx
/*  71 */           }, , { xx, ee, xx }, 
/*  72 */         }, 15);
/*  73 */     create(new FurnisherItemTile[][] {
/*  74 */           { xx, xx, xx, xx, xx
/*  75 */           }, , { xx, __, __, __, xx
/*  76 */           }, , { xx, __, __, __, xx
/*  77 */           }, , { xx, __, __, __, xx
/*  78 */           }, , { xx, __, __, __, xx
/*  79 */           }, , { xx, xx, ee, xx, xx }, 
/*  80 */         }, 30);
/*     */   }
/*     */ 
/*     */   
/*     */   private void create(FurnisherItemTile[][] tt, int am) {
/*  85 */     am++;
/*     */     
/*  87 */     for (int i = 2; i < am; i++) {
/*  88 */       FurnisherItemTile[][] tn = new FurnisherItemTile[tt.length][(tt[0]).length * i];
/*  89 */       for (int y = 0; y < tt.length; y++) {
/*  90 */         for (int x = 0; x < (tn[0]).length; x++) {
/*  91 */           tn[y][x] = tt[y][x % (tt[0]).length];
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     flush(3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 101 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 117 */     HomeInstance i = new HomeInstance(this.blue, area);
/*     */     
/* 119 */     for (COORDINATE c : i.body()) {
/* 120 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 121 */         int x = c.x() + ((DIR)DIR.ALL.get(di)).x();
/* 122 */         int y = c.y() + ((DIR)DIR.ALL.get(di)).y();
/* 123 */         SETT.TERRAIN().get(x, y).placeFixed(x, y);
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     return (Room)i;
/*     */   }
/*     */ 
/*     */   
/*     */   public FurnisherItem secretReplacementItem(int rot, FurnisherItem it) {
/* 132 */     return it.group.item(0, rot);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 137 */     return this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needsIsolation() {
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState getConstructionState() {
/* 147 */     return new HomeInstance.State(null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\HomeContructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */