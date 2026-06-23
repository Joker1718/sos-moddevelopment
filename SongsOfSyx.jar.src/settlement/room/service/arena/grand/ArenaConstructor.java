/*     */ package settlement.room.service.arena.grand;
/*     */ 
/*     */ import init.sprite.SPRITES;
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
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class ArenaConstructor extends Furnisher {
/*  36 */   private final int minDim = 24;
/*  37 */   private static CharSequence ¤¤notRec = "The blueprint must be in the shape of a rectangle";
/*  38 */   private static CharSequence ¤¤small = "This is too small to be considered a grand arena. Minimum dimensions are 24 x 24 tiles.";
/*  39 */   private static CharSequence ¤¤onEdge = "Entrance must be placed on the edge of the room.";
/*  40 */   private static CharSequence ¤¤onEdgeC = "Entrance must be placed in the center of an edge of the room.";
/*     */   
/*     */   static {
/*  43 */     D.ts(ArenaConstructor.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final ROOM_ARENA blue;
/*     */   
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat spectators;
/*     */   public final CUtil util;
/*  52 */   private double ri = 0.0D;
/*  53 */   private int cGlad = 0;
/*  54 */   private int cSpec = 0;
/*     */   
/*     */   private boolean err = false;
/*     */   
/*     */   private final RoomSprite1x1 csprite;
/*     */   
/*     */   protected ArenaConstructor(final ROOM_ARENA blue, RoomInitData init) throws IOException {
/*  61 */     super(init, 1, 2);
/*     */     
/*  63 */     Json sp = init.data().json("SPRITES");
/*  64 */     this.util = new CUtil(this, sp);
/*     */     
/*  66 */     this.csprite = new RoomSprite1x1(sp, "CONSTRUCT_1X1");
/*     */     
/*  68 */     this.blue = blue;
/*     */ 
/*     */     
/*  71 */     this.workers = new FurnisherStat(this)
/*     */       {
/*     */         public GText format(GText t, double value)
/*     */         {
/*  75 */           return GFORMAT.i(t, (long)value);
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(AREA area, double acc) {
/*  80 */           ArenaConstructor.this.init(area);
/*  81 */           return ArenaConstructor.this.cGlad;
/*     */         }
/*     */       };
/*     */     
/*  85 */     this.spectators = new FurnisherStat(this)
/*     */       {
/*     */         public GText format(GText t, double value)
/*     */         {
/*  89 */           GFORMAT.i(t, (int)Math.ceil(value));
/*  90 */           t.s();
/*  91 */           t.add('(');
/*  92 */           GFORMAT.i(t, (int)Math.ceil(value * blue.service().totalMultiplier()));
/*  93 */           t.add(')');
/*  94 */           return t;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(AREA area, double acc) {
/*  99 */           ArenaConstructor.this.init(area);
/* 100 */           return ArenaConstructor.this.cSpec;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 106 */     FurnisherItemTile ee = new FurnisherItemTile(
/* 107 */         this, 
/* 108 */         true, 
/* 109 */         (RoomSprite)RoomSprite1x1.DUMMY, 
/* 110 */         AVAILABILITY.SOLID, 
/* 111 */         false)
/*     */       {
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry)
/*     */         {
/* 117 */           if (ArenaConstructor.this.util.getLevel(tx, ty) != 0)
/* 118 */             return ArenaConstructor.¤¤onEdge; 
/* 119 */           if (!ArenaConstructor.this.util.canBeEntrance(tx, ty)) {
/* 120 */             return ArenaConstructor.¤¤onEdgeC;
/*     */           }
/* 122 */           return null;
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
/* 133 */     flush(4, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(AREA area) {
/* 140 */     if (this.ri != VIEW.renderSecond()) {
/* 141 */       this.err = false;
/* 142 */       this.ri = VIEW.renderSecond();
/* 143 */       this.cSpec = 0;
/* 144 */       this.cGlad = 0;
/* 145 */       if (area.body().width() < 24 || area.body().height() < 24)
/* 146 */         this.err = true; 
/* 147 */       for (COORDINATE c : area.body()) {
/* 148 */         if (!area.is(c)) {
/* 149 */           this.err = true;
/*     */           break;
/*     */         } 
/* 152 */         FurnisherItemTile it = this.util.get(c.x(), c.y(), area);
/* 153 */         if (it == this.util.iSeat1 || it == this.util.iSeat2)
/* 154 */           this.cSpec++; 
/* 155 */         if (it == this.util.iArena) {
/* 156 */           this.cGlad++;
/*     */         }
/*     */       } 
/* 159 */       this.cSpec -= 10;
/* 160 */       this.cGlad /= 6;
/*     */       
/* 162 */       if (this.err) {
/* 163 */         this.cSpec = 0;
/* 164 */         this.cGlad = 0;
/*     */       } 
/*     */       
/* 167 */       if (this.cGlad > 0) {
/* 168 */         this.cGlad = CLAMP.i(this.cSpec / 40, 1, this.cGlad);
/*     */       }
/*     */       
/* 171 */       this.cSpec = Math.max(this.cSpec, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 181 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 191 */     Rec rec = this.util.init(area);
/* 192 */     ArenaInstance a = new ArenaInstance(this.blue, area, init, (RECTANGLE)rec);
/* 193 */     for (COORDINATE c : a.body()) {
/* 194 */       if (a.is(c) && this.util.tile(c.x(), c.y()) == this.util.iTorch) {
/* 195 */         SETT.LIGHTS().candle(c.x(), c.y(), 0);
/*     */       }
/*     */     } 
/* 198 */     return (Room)a;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence constructionProblem(AREA area) {
/* 203 */     if (area.body().width() < 24 || area.body().height() < 24)
/* 204 */       return ¤¤small; 
/* 205 */     for (COORDINATE c : area.body()) {
/* 206 */       if (!area.is(c))
/* 207 */         return ¤¤notRec; 
/*     */     } 
/* 209 */     return super.constructionProblem(area);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 214 */     FurnisherItemTile it = this.util.get(tx, ty);
/*     */     
/* 216 */     if (it == this.util.iRim || it == this.util.iArena) {
/* 217 */       super.putFloor(tx, ty, upgrade, area);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTileBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, boolean floored) {
/* 223 */     if (floored && this.util.get(it.tx(), it.ty()) != this.util.iArena) {
/* 224 */       this.csprite.render(r, s, 0, it, 0.0D, false);
/*     */     }
/* 226 */     super.renderTileBelow(r, s, it, floored);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 231 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderEmbryo(SPRITE_RENDERER r, int mask, RenderData.RenderIterator it, boolean isFloored, AREA area, boolean active) {
/* 237 */     init(area);
/*     */     
/* 239 */     if (this.err) {
/* 240 */       if (active)
/* 241 */         (GCOLOR.MAP()).BAD.bind(); 
/* 242 */       super.renderEmbryo(r, mask, it, isFloored, area, active);
/*     */     } else {
/*     */       
/* 245 */       FurnisherItemTile tile = this.util.get(it.tx(), it.ty(), area);
/* 246 */       int m = 0;
/* 247 */       for (DIR d : DIR.ORTHO) {
/* 248 */         if ((this.util.get(it.tx() + d.x(), it.ty() + d.y(), area)).availability == tile.availability) {
/* 249 */           m |= d.mask();
/*     */         }
/*     */       } 
/* 252 */       if (tile.availability.player < 0.0D) {
/* 253 */         (SPRITES.cons()).BIG.solid.render(r, m, it.x(), it.y());
/*     */       } else {
/* 255 */         (SPRITES.cons()).BIG.outline.render(r, m, it.x(), it.y());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\ArenaConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */