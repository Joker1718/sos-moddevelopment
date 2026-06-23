/*     */ package settlement.room.spirit.dump;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ 
/*     */ final class Constructor extends Furnisher {
/*     */   private final ROOM_DUMP p;
/*     */   private final TILE_SHEET sheet;
/*     */   
/*  33 */   final FurnisherStat total = new FurnisherStat(this, 1.0D)
/*     */     {
/*     */       public double get(AREA area, double acc)
/*     */       {
/*  37 */         int a = 0;
/*  38 */         for (COORDINATE c : area.body()) {
/*  39 */           if (area.is(c) && 
/*  40 */             !Constructor.this.isEdge(c.x(), c.y(), area)) {
/*  41 */             a++;
/*     */           }
/*     */         } 
/*     */         
/*  45 */         return a;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  50 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */   
/*     */   protected Constructor(ROOM_DUMP p, RoomInitData init) throws IOException {
/*  55 */     super(init, 0, 1, 384, 108);
/*  56 */     this.p = p;
/*     */     
/*  58 */     this.sheet = (new ComposerThings.ITileSheet(init.sp(), 384, 64)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  62 */           s.house2.init(0, 0, 2, 1, (ComposerDests.Dest)d.s16);
/*  63 */           s.house2.setVar(0).paste(1, true);
/*  64 */           s.house2.setVar(1).paste(1, true);
/*  65 */           return d.s16.saveGame();
/*     */         }
/*  67 */       }).get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/*  73 */     return true;
/*     */   }
/*     */   
/*  76 */   private static CharSequence ¤¤TooThin = "¤Area is too thin at places. Expand the area to at least 3x3 everywhere.";
/*     */ 
/*     */   
/*     */   public boolean joinsWithFloor() {
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   static {
/*  84 */     D.ts(Constructor.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence constructionProblem(AREA area) {
/*  89 */     for (COORDINATE c : area.body()) {
/*     */       
/*  91 */       if (area.is(c)) {
/*  92 */         boolean any = false;
/*  93 */         for (int di = 0; di < DIR.ALLC.size(); di++) {
/*  94 */           DIR d = (DIR)DIR.ALLC.get(di);
/*  95 */           if (area.is(c, d) && !isEdge(c.x() + d.x(), c.y() + d.y(), area)) {
/*  96 */             any = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 100 */         if (!any) {
/* 101 */           return ¤¤TooThin;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 123 */     return (Room)new DumpInstance(this.p, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 128 */     return (RoomBlueprintImp)this.p;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTileBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, boolean floored) {
/* 133 */     int m = (SETT.ROOMS()).fData.spriteData.get(it.tile());
/* 134 */     if ((m & 0x10) != 0) {
/* 135 */       this.sheet.render(r, (m & 0xF) + 16 * (it.ran() & 0x3), it.x(), it.y());
/* 136 */     } else if (blue().is(it.tile())) {
/* 137 */       ((Floors.Floor)this.floors.get(0)).tint.color.bind();
/* 138 */       ((Floors.Floor)this.floors.get(0)).sheet.render(r, it.ran() & 0xF, it.x(), it.y());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void doBeforePlanning(int tx, int ty) {
/* 144 */     (SETT.ROOMS()).fData.spriteData.set(tx, ty, 0);
/* 145 */     super.doBeforePlanning(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 150 */     if (isEdge(tx, ty, area)) {
/* 151 */       set(tx, ty, area);
/* 152 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 153 */         DIR d = (DIR)DIR.ALL.get(di);
/* 154 */         if (isEdge(tx + d.x(), ty + d.y(), area)) {
/* 155 */           set(tx + d.x(), ty + d.y(), area);
/*     */         }
/*     */       } 
/*     */     } else {
/* 159 */       (SETT.ROOMS()).fData.spriteData.set(tx, ty, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void set(int tx, int ty, AREA area) {
/* 164 */     int m = 0;
/* 165 */     for (DIR d : DIR.NORTHO) {
/* 166 */       if (joins(tx, ty, d, area) && joins(tx, ty, d.next(-1), area) && joins(tx, ty, d.next(1), area))
/* 167 */         m |= d.mask(); 
/*     */     } 
/* 169 */     (SETT.ROOMS()).fData.spriteData.set(tx, ty, 0x10 | m);
/*     */   }
/*     */   
/*     */   private boolean joins(int tx, int ty, DIR d, AREA area) {
/* 173 */     tx += d.x();
/* 174 */     ty += d.y();
/* 175 */     if (!area.is(tx, ty))
/* 176 */       return true; 
/* 177 */     if (isEdge(tx, ty, area))
/* 178 */       return true; 
/* 179 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isEdge(int tx, int ty, AREA area) {
/* 183 */     if (!area.is(tx, ty))
/* 184 */       return false; 
/* 185 */     for (DIR d : DIR.ALL) {
/* 186 */       if (!area.is(tx, ty, d))
/* 187 */         return true; 
/* 188 */     }  return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\dump\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */