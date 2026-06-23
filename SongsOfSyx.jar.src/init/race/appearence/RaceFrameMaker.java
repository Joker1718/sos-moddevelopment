/*     */ package init.race.appearence;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RaceFrameMaker
/*     */ {
/*     */   public static final int TILES_X = 5;
/*     */   public static final int TILES_Y = 5;
/*     */   public static final int TILE_SIZE = 8;
/*     */   private static final int FRAMES_X = 4;
/*  32 */   private KeyMap<LIST<RaceFrameRaw>> map = new KeyMap();
/*     */ 
/*     */ 
/*     */   
/*     */   public final LIST<RaceFrameRaw> grit;
/*     */ 
/*     */ 
/*     */   
/*     */   public final LIST<RaceFrameRaw> blood;
/*     */ 
/*     */ 
/*     */   
/*     */   private final TILE_SHEET DUMMY;
/*     */ 
/*     */ 
/*     */   
/*     */   private final RaceFrameRaw dFrame;
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<RaceFrameRaw> read(Json json) throws IOException {
/*  53 */     String[] vals = json.values("FRAMES");
/*     */     
/*  55 */     ArrayListGrower<RaceFrameRaw> frames = new ArrayListGrower(); byte b; int i;
/*     */     String[] arrayOfString1;
/*  57 */     for (i = (arrayOfString1 = vals).length, b = 0; b < i; ) { String val = arrayOfString1[b];
/*  58 */       if (!read(frames, val, json)) {
/*  59 */         GAME.WarnLight("Unable to parse key " + val + " these keys should be FILE:INDEX, where FILE is a file in the portrait folder, and INDEX is the frame in that file (integer)");
/*     */       }
/*     */       
/*     */       b++; }
/*     */     
/*  64 */     return (LIST<RaceFrameRaw>)frames;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean read(ArrayListGrower<RaceFrameRaw> frames, String val, Json json) throws IOException {
/*  70 */     String[] ss = val.split(":");
/*  71 */     if (ss.length == 2) {
/*  72 */       String file = ss[0].trim();
/*     */       try {
/*  74 */         Integer row = Integer.valueOf(Integer.parseInt(ss[1].trim()));
/*  75 */         if (row != null) {
/*  76 */           frames.add(frame(file, row.intValue(), json));
/*     */         }
/*  78 */         return true;
/*  79 */       } catch (NumberFormatException e) {
/*  80 */         return false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RaceFrameRaw frame(String file, int row, Json error) throws IOException {
/*  93 */     if (!(PATHS.RACE()).sprite.getFolder("face").exists(file)) {
/*  94 */       if (error != null) {
/*  95 */         GAME.Warn("the face file: " + file + " does not exist");
/*  96 */         return this.dFrame;
/*     */       } 
/*  98 */       throw new RuntimeException(file);
/*     */     } 
/*     */     
/* 101 */     if (!this.map.containsKey(file)) {
/* 102 */       this.map.put(file, sheet(file));
/*     */     }
/* 104 */     LIST<RaceFrameRaw> rows = (LIST<RaceFrameRaw>)this.map.get(file);
/*     */     
/* 106 */     if (row < 0 || row >= rows.size()) {
/* 107 */       if (error != null) {
/* 108 */         GAME.Warn("the row number for face file: " + file + " is out of bounds " + row + " " + rows.size() - 1);
/* 109 */         return this.dFrame;
/*     */       } 
/* 111 */       throw new RuntimeException(file);
/*     */     } 
/*     */     
/* 114 */     return (RaceFrameRaw)rows.get(row);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LIST<RaceFrameRaw> sheet(String file) throws IOException {
/* 121 */     Path pp = (PATHS.RACE()).sprite.getFolder("face").get(file);
/*     */ 
/*     */ 
/*     */     
/* 125 */     SnakeImage im = new SnakeImage(pp);
/* 126 */     int ww = 416;
/* 127 */     int hh = 60;
/* 128 */     if (im.width != ww || im.height < hh) {
/* 129 */       throw new RuntimeException(pp.toString() + " has wrong dimensions " + pp.toString() + " " + im.width);
/*     */     }
/*     */     
/* 132 */     final int framesY = im.height / hh;
/*     */     
/* 134 */     int[][] offYs = Alloc.i2(framesY, 4);
/* 135 */     int[][] startYs = Alloc.i2(framesY, 4);
/* 136 */     int[][] rowss = Alloc.i2(framesY, 4);
/*     */ 
/*     */     
/* 139 */     for (int fy = 0; fy < framesY; fy++) {
/* 140 */       for (int fx = 0; fx < 4; fx++) {
/*     */         
/* 142 */         int sx = 6 + 52 * fx;
/* 143 */         int sy = 6 + 60 * fy;
/*     */         
/* 145 */         int y1 = sy;
/* 146 */         int y2 = y1 + 48;
/*     */         int dy;
/* 148 */         label58: for (dy = 0; dy < 48; dy++) {
/* 149 */           for (int dx = 0; dx < 40; dx++) {
/* 150 */             int x = sx + dx;
/* 151 */             if ((im.rgb.get(x, y1) & 0xFF) != 0) {
/*     */               break label58;
/*     */             }
/*     */           } 
/* 155 */           y1++;
/*     */         } 
/*     */ 
/*     */         
/* 159 */         label59: for (dy = 0; dy < 48; dy++) {
/* 160 */           for (int dx = 0; dx < 40; dx++) {
/* 161 */             int x = sx + dx;
/* 162 */             if ((im.rgb.get(x, y2 - 1) & 0xFF) != 0) {
/*     */               break label59;
/*     */             }
/*     */           } 
/* 166 */           y2--;
/*     */         } 
/*     */         
/* 169 */         int offY = y1 - sy;
/*     */         
/* 171 */         final int rows = (int)Math.ceil((y2 - y1) / 8.0D);
/*     */         
/* 173 */         if (y1 + rows * 8 > sy + 48) {
/* 174 */           y1 = sy + 48 - rows * 8;
/* 175 */           offY -= offY - y1 - sy;
/*     */         } 
/*     */         
/* 178 */         offYs[fy][fx] = offY;
/* 179 */         startYs[fy][fx] = y1 - sy;
/* 180 */         rowss[fy][fx] = rows;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 186 */     im.dispose();
/*     */ 
/*     */ 
/*     */     
/* 190 */     LinkedList<RaceFrameRaw> res = new LinkedList();
/* 191 */     for (int i = 0; i < framesY; i++) {
/*     */       
/* 193 */       for (int fx = 0; fx < 4; fx++) {
/*     */ 
/*     */ 
/*     */         
/* 197 */         int offY = offYs[i][fx];
/* 198 */         final int startY = startYs[i][fx];
/* 199 */         final int rows = rowss[i][fx];
/*     */         
/* 201 */         final int var = fx + i * 4;
/*     */         
/* 203 */         TILE_SHEET sheet = (new ComposerThings.ITileSheet()
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 207 */               if (rows == 0) {
/* 208 */                 return RaceFrameMaker.this.dFrame.sheet;
/*     */               }
/* 210 */               s.full.init(0, startY, 4, framesY, 5, 6, d.s8);
/* 211 */               s.full.setVar(var);
/* 212 */               s.full.setSkip(rows * 5, 0);
/* 213 */               s.full.paste(true);
/* 214 */               return d.s8.save(1);
/*     */             }
/* 216 */           }).get();
/* 217 */         res.add(new RaceFrameRaw(this, sheet, offY));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 222 */     return (LIST<RaceFrameRaw>)res;
/*     */   }
/*     */ 
/*     */   
/*     */   public RaceFrameMaker() throws IOException {
/* 227 */     this.DUMMY = new TILE_SHEET()
/*     */       {
/*     */         public int tiles()
/*     */         {
/* 231 */           return 5;
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 236 */           return 8;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int tile, int x1, int x2, int scale) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int tile, int x1, int y1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int tile, int x1, int x2, int y1, int y2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TextureCoords getTexture(int tile) {
/* 260 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 264 */     this.dFrame = new RaceFrameRaw(this, this.DUMMY, 0);
/*     */     ArrayList<RaceFrameRaw> ff = new ArrayList(4);
/*     */     int i;
/*     */     for (i = 0; i < ff.max(); i++)
/*     */       ff.add(frame("_Overlays", i, null)); 
/*     */     this.grit = (LIST<RaceFrameRaw>)ff;
/*     */     ff = new ArrayList(4);
/*     */     for (i = 0; i < ff.max(); i++)
/*     */       ff.add(frame("_Overlays", 4 + i, null)); 
/*     */     this.blood = (LIST<RaceFrameRaw>)ff;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RaceFrameMaker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */