/*     */ package settlement.room.main.copy;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.structure.STRUCTURES;
/*     */ import init.structure.Structure;
/*     */ import java.util.LinkedList;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.placement.UtilWallPlacability;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SavedPrints
/*     */ {
/*     */   private final LIST<ArrayListGrower<SavedPrint>> all;
/*  34 */   private static String fileName = "SavedPrints71";
/*     */ 
/*     */   
/*     */   SavedPrints(ROOMS rooms) {
/*  38 */     ArrayList<ArrayListGrower<SavedPrint>> all = new ArrayList(rooms.AMOUNT_OF_BLUEPRINTS);
/*  39 */     while (all.hasRoom())
/*  40 */       all.add(new ArrayListGrower()); 
/*  41 */     this.all = (LIST<ArrayListGrower<SavedPrint>>)all;
/*     */     
/*     */     try {
/*  44 */       Json[] jsons = (new Json((PATHS.local()).PROFILE.gets(fileName))).jsons("BLUEPRINTS"); byte b; int i; Json[] arrayOfJson1;
/*  45 */       for (i = (arrayOfJson1 = jsons).length, b = 0; b < i; ) { Json j = arrayOfJson1[b];
/*  46 */         SavedPrint p = new SavedPrint(rooms, j);
/*  47 */         if (p.blue != null && p.blue.constructor() != null && p.blue.constructor().canBeCopied() && p.check.equals(SavedPrint.check(p.blue)))
/*  48 */           add(p); 
/*     */         b++; }
/*     */     
/*  51 */     } catch (Exception e) {
/*  52 */       e.printStackTrace(System.out);
/*  53 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save() {
/*  60 */     LinkedList<JsonE> all = new LinkedList<>();
/*     */     
/*  62 */     for (LIST<SavedPrint> ll : this.all) {
/*  63 */       for (SavedPrint l : ll)
/*  64 */         all.add(l.save()); 
/*     */     } 
/*  66 */     JsonE[] jsons = new JsonE[all.size()];
/*  67 */     int i = 0;
/*  68 */     for (JsonE e : all) {
/*  69 */       jsons[i++] = e;
/*     */     }
/*  71 */     JsonE json = new JsonE();
/*  72 */     json.add("BLUEPRINTS", jsons);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  77 */       if (!(PATHS.local()).PROFILE.exists(fileName)) {
/*  78 */         (PATHS.local()).PROFILE.create(fileName);
/*     */       }
/*  80 */       json.save((PATHS.local()).PROFILE.get(fileName));
/*     */     }
/*  82 */     catch (Exception e) {
/*  83 */       e.printStackTrace(System.out);
/*  84 */       all.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public SavedPrint push(Room ins, int mx, int my) {
/*  89 */     if (canAdd(ins)) {
/*  90 */       SavedPrint p = new SavedPrint(ins, mx, my);
/*  91 */       add(p);
/*  92 */       save();
/*  93 */       return p;
/*     */     } 
/*  95 */     return null;
/*     */   }
/*     */   
/*     */   public void remove(SavedPrint print) {
/*  99 */     ((ArrayListGrower)this.all.get(print.blue.index())).remove(print);
/* 100 */     save();
/*     */   }
/*     */   
/*     */   private void add(SavedPrint p) {
/* 104 */     ((ArrayListGrower)this.all.get(p.blue.index())).add(p);
/*     */   }
/*     */   
/*     */   public LIST<SavedPrint> all(RoomBlueprint p) {
/* 108 */     return (LIST<SavedPrint>)this.all.get(p.index());
/*     */   }
/*     */   
/*     */   public boolean canAdd(Room ins) {
/* 112 */     if (ins.constructor() == null)
/* 113 */       return false; 
/* 114 */     return canAdd((RoomBlueprint)ins.constructor().blue());
/*     */   }
/*     */   
/*     */   public boolean canAdd(RoomBlueprint b) {
/* 118 */     if (b instanceof settlement.room.main.RoomBlueprintIns) {
/* 119 */       RoomBlueprintImp bb = (RoomBlueprintImp)b;
/* 120 */       if (bb.constructor() == null)
/* 121 */         return false; 
/* 122 */       if (!bb.constructor().usesArea())
/* 123 */         return false; 
/* 124 */       if (!bb.constructor().canBeCopied())
/* 125 */         return false; 
/* 126 */       return true;
/*     */     } 
/* 128 */     return false;
/*     */   }
/*     */   
/*     */   public static class SavedPrint {
/*     */     public CharSequence name;
/*     */     public final RoomBlueprintImp blue;
/*     */     public final String check;
/*     */     public final int width;
/*     */     public final int height;
/*     */     public final Structure structure;
/*     */     private final int[] data;
/* 139 */     private static final RoomAreaWrapper.RoomWrap wrap = new RoomAreaWrapper.RoomWrap();
/*     */ 
/*     */     
/*     */     SavedPrint(ROOMS rr, Json json) {
/* 143 */       this.name = json.text("NAME");
/* 144 */       RoomBlueprint pp = (RoomBlueprint)rr.collection.tryGet(json.value("ROOM"));
/* 145 */       this.blue = (pp instanceof RoomBlueprintImp) ? (RoomBlueprintImp)pp : null;
/* 146 */       this.check = json.has("CHECK") ? json.value("CHECK") : "";
/* 147 */       this.width = json.i("WIDTH");
/* 148 */       this.height = json.i("HEIGHT");
/* 149 */       this.data = json.is("DATA");
/* 150 */       if (json.has("STRUCTURE") || json.value("STRUCTURE").equals("_")) {
/* 151 */         this.structure = null;
/*     */       } else {
/* 153 */         this.structure = (Structure)STRUCTURES.map().readTry("STRUCTURE", json);
/*     */       } 
/*     */     }
/*     */     
/*     */     JsonE save() {
/* 158 */       JsonE j = new JsonE();
/* 159 */       j.addString("NAME", String.valueOf(this.name));
/* 160 */       j.add("ROOM", this.blue.key);
/* 161 */       j.add("STRUCTURE", (this.structure == null) ? "_" : this.structure.key);
/* 162 */       j.add("CHECK", this.check);
/* 163 */       j.add("WIDTH", this.width);
/* 164 */       j.add("HEIGHT", this.height);
/* 165 */       j.add("DATA", this.data);
/*     */       
/* 167 */       return j;
/*     */     }
/*     */     
/*     */     private static String check(RoomBlueprintImp blue) {
/* 171 */       String ch = "";
/* 172 */       Furnisher f = blue.constructor();
/* 173 */       ch = ch + ch;
/* 174 */       for (FurnisherItemGroup g : f.groups()) {
/* 175 */         ch = ch + ch;
/* 176 */         ch = ch + ch;
/* 177 */         ch = ch + ch;
/* 178 */         ch = ch + ch;
/*     */         
/* 180 */         for (int i = 0; i < g.size(); i++) {
/* 181 */           FurnisherItem it = g.item(i, 0);
/* 182 */           ch = ch + ch;
/* 183 */           ch = ch + ch;
/* 184 */           for (int h = 0; h < it.height(); h++) {
/* 185 */             for (int w = 0; w < it.width(); w++) {
/* 186 */               ch = ch + ch + " " + h + w;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 191 */       return ch;
/*     */     }
/*     */ 
/*     */     
/*     */     SavedPrint(String name, SavedPrint other) {
/* 196 */       this.name = name;
/* 197 */       this.blue = other.blue;
/* 198 */       this.check = other.check;
/* 199 */       this.width = other.width;
/* 200 */       this.height = other.height;
/* 201 */       this.data = other.data;
/* 202 */       this.structure = other.structure;
/*     */     }
/*     */     
/*     */     SavedPrint(Room ins, int mx, int my) {
/* 206 */       wrap.init(ins, mx, my);
/* 207 */       this.name = String.valueOf(ins.name(mx, my));
/* 208 */       this.blue = ins.constructor().blue();
/* 209 */       this.check = check(this.blue);
/* 210 */       this.width = wrap.body().width() + 2;
/* 211 */       this.height = wrap.body().height() + 2;
/* 212 */       this.data = Alloc.ii(this.width * this.height);
/* 213 */       TBuilding b = ConstructionInit.findStructure(mx, my);
/* 214 */       this.structure = (b == null) ? null : b.structure;
/*     */       
/* 216 */       for (int dy = 0; dy < this.height; dy++) {
/* 217 */         for (int dx = 0; dx < this.width; dx++) {
/* 218 */           int di = dx + dy * this.width;
/* 219 */           int x = dx + wrap.body().x1() - 1;
/* 220 */           int y = dy + wrap.body().y1() - 1;
/* 221 */           if (wrap.is(x, y)) {
/* 222 */             this.data[di] = this.data[di] | 0x1;
/* 223 */             if (SETT.TERRAIN().get(x, y).roofIs())
/* 224 */               this.data[di] = this.data[di] | 0x4; 
/* 225 */             if ((SETT.PATH()).availability.get(x, y) != AVAILABILITY.ROOM) {
/* 226 */               this.data[di] = this.data[di] | 0x8;
/*     */             }
/* 228 */             if ((SETT.ROOMS()).fData.isMaster.is(x, y)) {
/* 229 */               FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(x, y);
/* 230 */               this.data[dx + dy * this.width] = this.data[dx + dy * this.width] | it.index() + 1 << 4;
/*     */             } 
/*     */           } else {
/*     */             
/* 234 */             boolean is = false;
/* 235 */             for (DIR d : DIR.ALL) {
/* 236 */               if (wrap.is(x, y, d)) {
/* 237 */                 is = true;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 241 */             if (is)
/* 242 */               if (UtilWallPlacability.openingIsReal.is(x, y)) {
/* 243 */                 this.data[di] = this.data[di] | 0x4;
/* 244 */               } else if (UtilWallPlacability.wallisReal.is(x, y)) {
/* 245 */                 this.data[di] = this.data[di] | 0x2;
/*     */               }  
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isRoom(int rx, int ry) {
/* 253 */       return ((this.data[rx + ry * this.width] & 0x1) != 0);
/*     */     }
/*     */     
/*     */     public boolean isWall(int rx, int ry) {
/* 257 */       return ((this.data[rx + ry * this.width] & 0x2) != 0);
/*     */     }
/*     */     
/*     */     public boolean isRoof(int rx, int ry) {
/* 261 */       return ((this.data[rx + ry * this.width] & 0x4) != 0);
/*     */     }
/*     */     
/*     */     public boolean isSoldid(int rx, int ry) {
/* 265 */       return ((this.data[rx + ry * this.width] & 0x8) != 0);
/*     */     }
/*     */     
/*     */     public FurnisherItem item(int rx, int ry, RoomBlueprintImp blue) {
/* 269 */       int i = (this.data[rx + ry * this.width] & 0xFFFF0) >> 4;
/* 270 */       if (i > 0) {
/* 271 */         return blue.constructor().item(i - 1);
/*     */       }
/* 273 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\SavedPrints.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */