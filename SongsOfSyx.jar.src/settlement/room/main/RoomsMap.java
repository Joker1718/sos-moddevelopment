/*     */ package settlement.room.main;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_INT;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RoomsMap
/*     */   implements MAP_OBJECT<Room>
/*     */ {
/*     */   private static final int NOTHING = 0;
/*  26 */   private final int[] roomI = Alloc.ii(SETT.TAREA);
/*     */   
/*  28 */   private int singletonI = 1;
/*     */   
/*     */   private static final int singletonMax = 256;
/*     */   private static final int CHUNKSIZE = 1024;
/*  32 */   private Room[] rooms = new Room[1024];
/*  33 */   private int lastIndex = 256;
/*     */   final SAVABLE saver;
/*     */   private final Rec tmp;
/*     */   public final MAP_OBJECT<RoomBlueprint> blueprint;
/*     */   
/*     */   RoomsMap() {
/*  39 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  43 */           file.i(RoomsMap.this.rooms.length);
/*  44 */           file.is(RoomsMap.this.roomI);
/*     */           
/*  46 */           int am = 0; byte b; int i; Room[] arrayOfRoom;
/*  47 */           for (i = (arrayOfRoom = RoomsMap.this.rooms).length, b = 0; b < i; ) { Room r = arrayOfRoom[b];
/*  48 */             if (r != null && !r.singleton)
/*  49 */               am++;  b++; }
/*     */           
/*  51 */           file.i(am);
/*     */           
/*  53 */           for (i = (arrayOfRoom = RoomsMap.this.rooms).length, b = 0; b < i; ) { Room r = arrayOfRoom[b];
/*  54 */             if (r != null && !r.singleton) {
/*     */               
/*  56 */               (SETT.ROOMS()).collection.saver().save(r.blueprint(), file);
/*     */               
/*  58 */               int pos = file.getPosition();
/*  59 */               file.i(0);
/*  60 */               file.object(r);
/*  61 */               r.saveExtra(file);
/*  62 */               int le = file.getPosition() - pos - 4;
/*  63 */               file.setAtPosition(pos, le);
/*     */             } 
/*     */             b++; }
/*     */         
/*     */         }
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  70 */           Room[] nn = new Room[file.i()];
/*  71 */           file.is(RoomsMap.this.roomI);
/*     */           
/*  73 */           for (int i = 0; i < 256; i++) {
/*  74 */             nn[i] = RoomsMap.this.rooms[i];
/*     */           }
/*  76 */           RoomsMap.this.rooms = nn;
/*     */           
/*  78 */           int am = file.i();
/*     */           int j;
/*  80 */           for (j = 0; j < am; j++) {
/*  81 */             RoomBlueprint print = (RoomBlueprint)(SETT.ROOMS()).collection.loader().load(file);
/*  82 */             int le = file.i();
/*  83 */             if (print != null) {
/*  84 */               Room r = (Room)file.object(true);
/*  85 */               if (r != null) {
/*  86 */                 r.bI = (short)print.index();
/*  87 */                 if (r.loadExtra(file)) {
/*  88 */                   r.loadFix();
/*  89 */                   RoomsMap.this.rooms[r.index()] = r;
/*     */                   
/*     */                   continue;
/*     */                 } 
/*     */               } 
/*     */             } 
/*  95 */             file.setPosition(file.getPosition() + le);
/*     */             
/*     */             continue;
/*     */           } 
/*  99 */           for (j = 0; j < SETT.TAREA; j++) {
/* 100 */             if (RoomsMap.this.roomI[j] != 0 && RoomsMap.this.rooms[RoomsMap.this.roomI[j]] == null) {
/* 101 */               (SETT.ROOMS()).fData.clean(j);
/* 102 */               (SETT.ROOMS()).pData.set(j, 0);
/*     */             } 
/*     */           } 
/*     */           
/* 106 */           for (RoomsMap.this.lastIndex = RoomsMap.this.singletonI; RoomsMap.this.lastIndex < RoomsMap.this.roomI.length && 
/* 107 */             RoomsMap.this.roomI[RoomsMap.this.lastIndex] != 0; RoomsMap.this.lastIndex++);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void clear() {
/* 116 */           Room[] nn = new Room[1024]; int i;
/* 117 */           for (i = 0; i < RoomsMap.this.singletonI; i++) {
/* 118 */             nn[i] = RoomsMap.this.rooms[i];
/*     */           }
/* 120 */           RoomsMap.this.rooms = nn;
/* 121 */           for (i = 0; i < SETT.TAREA; i++) {
/* 122 */             RoomsMap.this.roomI[i] = 0;
/*     */           }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     this.tmp = new Rec();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     this.blueprint = new MAP_OBJECT<RoomBlueprint>()
/*     */       {
/*     */         public RoomBlueprint get(int tile)
/*     */         {
/* 250 */           int i = RoomsMap.this.roomI[tile];
/* 251 */           if (i != 0) {
/* 252 */             Room r = RoomsMap.this.getByIndex(i);
/* 253 */             if (r != null)
/* 254 */               return r.blueprint(); 
/*     */           } 
/* 256 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RoomBlueprint get(int tx, int ty) {
/* 261 */           if (SETT.IN_BOUNDS(tx, ty))
/* 262 */             return get(tx + ty * SETT.TWIDTH); 
/* 263 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 268 */     this.blueprintImp = new MAP_OBJECT<RoomBlueprintImp>()
/*     */       {
/*     */         public RoomBlueprintImp get(int tile)
/*     */         {
/* 272 */           int i = RoomsMap.this.roomI[tile];
/* 273 */           if (i != 0) {
/* 274 */             Room r = RoomsMap.this.getByIndex(i);
/* 275 */             if (r != null && r.constructor() != null)
/* 276 */               return r.constructor().blue(); 
/*     */           } 
/* 278 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RoomBlueprintImp get(int tx, int ty) {
/* 283 */           if (SETT.IN_BOUNDS(tx, ty))
/* 284 */             return get(tx + ty * SETT.TWIDTH); 
/* 285 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 290 */     this.indexGetter = new MAP_INT()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/* 294 */           return get(tx + ty * SETT.TWIDTH);
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/* 299 */           return RoomsMap.this.roomI[tile];
/*     */         }
/*     */       };
/*     */     
/* 303 */     this.instance = new MAP_OBJECT<RoomInstance>()
/*     */       {
/*     */         public RoomInstance get(int tile)
/*     */         {
/* 307 */           Room r = RoomsMap.this.get(tile);
/* 308 */           if (r instanceof RoomInstance)
/* 309 */             return (RoomInstance)r; 
/* 310 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RoomInstance get(int tx, int ty) {
/* 315 */           if (SETT.IN_BOUNDS(tx, ty))
/* 316 */             return get(tx + ty * SETT.TWIDTH); 
/* 317 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 322 */     this.rooma = new MAP_OBJECT<ROOMA>()
/*     */       {
/* 324 */         private final RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */ 
/*     */         
/*     */         public ROOMA get(int tile) {
/* 328 */           this.wrap.done();
/* 329 */           Room r = RoomsMap.this.get(tile);
/* 330 */           if (r != null)
/* 331 */             return this.wrap.init(r, tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/* 332 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public ROOMA get(int tx, int ty) {
/* 337 */           this.wrap.done();
/* 338 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 339 */             Room r = RoomsMap.this.get(tx, ty);
/* 340 */             if (r != null)
/* 341 */               return this.wrap.init(r, tx, ty); 
/*     */           } 
/* 343 */           return null;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public final MAP_OBJECT<RoomBlueprintImp> blueprintImp;
/*     */   public final MAP_INT indexGetter;
/*     */   public final MAP_OBJECT<RoomInstance> instance;
/*     */   public final MAP_OBJECT<ROOMA> rooma;
/*     */   
/*     */   public Room getByIndex(int index) {
/*     */     return this.rooms[index];
/*     */   }
/*     */   
/*     */   public int max() {
/*     */     return this.rooms.length;
/*     */   }
/*     */   
/*     */   int create(Room r, boolean singleton) {
/*     */     if (singleton) {
/*     */       if (this.singletonI > 256)
/*     */         throw new RuntimeException("too many singleton rooms!"); 
/*     */       int j = this.singletonI;
/*     */       this.singletonI++;
/*     */       if (this.rooms[j] != null)
/*     */         throw new RuntimeException(); 
/*     */       this.rooms[j] = r;
/*     */       return j;
/*     */     } 
/*     */     for (; this.lastIndex < this.rooms.length; this.lastIndex++) {
/*     */       if (this.rooms[this.lastIndex] == null) {
/*     */         this.rooms[this.lastIndex] = r;
/*     */         return this.lastIndex;
/*     */       } 
/*     */     } 
/*     */     this.lastIndex = this.singletonI;
/*     */     for (; this.lastIndex < this.rooms.length; this.lastIndex++) {
/*     */       if (this.rooms[this.lastIndex] == null) {
/*     */         this.rooms[this.lastIndex] = r;
/*     */         return this.lastIndex;
/*     */       } 
/*     */     } 
/*     */     Room[] nn = new Room[this.rooms.length + 1024];
/*     */     for (int i = 0; i < this.rooms.length; i++)
/*     */       nn[i] = this.rooms[i]; 
/*     */     this.rooms = nn;
/*     */     this.rooms[this.lastIndex] = r;
/*     */     return this.lastIndex;
/*     */   }
/*     */   
/*     */   final Room getRaw(int tx, int ty) {
/*     */     return this.rooms[this.roomI[tx + ty * SETT.TWIDTH]];
/*     */   }
/*     */   
/*     */   void set(int tile, Room n) {
/*     */     if (get(tile) != null)
/*     */       throw new RuntimeException("" + tile + " " + tile + " " + String.valueOf(n)); 
/*     */     (SETT.ROOMS()).fData.clean(tile);
/*     */     this.roomI[tile] = n.roomI;
/*     */     (SETT.ROOMS()).pData.set(tile, 0);
/*     */   }
/*     */   
/*     */   void clear(int tile, Room old) {
/*     */     if (old != get(tile))
/*     */       throw new RuntimeException("" + tile + " " + tile + " " + this.indexGetter.get(tile) + " " + String.valueOf(old) + " " + String.valueOf(get(tile))); 
/*     */     (SETT.ROOMS()).fData.clean(tile);
/*     */     (SETT.ROOMS()).pData.set(tile, 0);
/*     */     this.roomI[tile] = 0;
/*     */   }
/*     */   
/*     */   void replace(int tile, Room old, Room current) {
/*     */     if (old != get(tile))
/*     */       throw new RuntimeException("" + tile % SETT.TWIDTH + " " + tile % SETT.TWIDTH + " " + tile / SETT.TWIDTH + " " + String.valueOf(get(tile)) + " " + String.valueOf(old)); 
/*     */     this.roomI[tile] = current.roomI;
/*     */   }
/*     */   
/*     */   TmpArea delete(Room room, int mx, int my, Object user) {
/*     */     TmpArea a = SETT.ROOMS().tmpArea(user);
/*     */     a.set(room, mx, my);
/*     */     if (!(room instanceof RoomSingleton) && room.blueprint() != (SETT.ROOMS()).THRONE) {
/*     */       if (this.rooms[room.roomI] == null)
/*     */         throw new RuntimeException(); 
/*     */       this.rooms[room.roomI] = null;
/*     */       if (room.roomI < this.lastIndex)
/*     */         this.lastIndex = room.roomI; 
/*     */     } 
/*     */     init(a);
/*     */     return a;
/*     */   }
/*     */   
/*     */   public void init(AREA room) {
/*     */     this.tmp.set(room.body());
/*     */     for (COORDINATE c : this.tmp) {
/*     */       if (room.is(c)) {
/*     */         SETT.TILE_MAP().miniCUpdate(c.x(), c.y());
/*     */         (SETT.PATH()).availability.updateAvailability(c.x(), c.y());
/*     */         (SETT.ENV()).map.setChanged(c.x(), c.y());
/*     */         (SETT.PATH()).availability.updateService(c.x(), c.y());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Room get(int tile) {
/*     */     return this.rooms[this.roomI[tile]];
/*     */   }
/*     */   
/*     */   public Room get(int tx, int ty) {
/*     */     if (SETT.IN_BOUNDS(tx, ty))
/*     */       return this.rooms[this.roomI[tx + ty * SETT.TWIDTH]]; 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomsMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */