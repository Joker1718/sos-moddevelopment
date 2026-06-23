/*     */ package init.race.appearence;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.race.ExpandInit;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ public final class RCrown
/*     */ {
/*  22 */   private ArrayListGrower<SPRITE> crowns = new ArrayListGrower();
/*  23 */   private ArrayListGrower<SPRITE> raiders = new ArrayListGrower();
/*  24 */   private ArrayListGrower<SPRITE> merc = new ArrayListGrower();
/*     */   
/*     */   RCrown(ExpandInit init, Json data) throws IOException {
/*  27 */     make(init, data, "CROWN", this.crowns);
/*  28 */     make(init, data, "RAIDER", this.raiders);
/*  29 */     make(init, data, "MERC", this.merc);
/*     */   }
/*     */   
/*     */   private static void make(ExpandInit init, Json data, String key, ArrayListGrower<SPRITE> crowns) throws IOException {
/*  33 */     if (!data.has(key))
/*  34 */       data.error("Not declared", key); 
/*  35 */     if (data.has(key)) {
/*  36 */       if (data.arrayIs(key)) {
/*  37 */         byte b; int i; Json[] arrayOfJson; for (i = (arrayOfJson = data.jsons(key)).length, b = 0; b < i; ) { Json j = arrayOfJson[b];
/*  38 */           make(j, init, crowns); b++; }
/*     */       
/*     */       } else {
/*  41 */         data = data.json(key);
/*  42 */         make(data, init, crowns);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static void make(Json json, ExpandInit init, ArrayListGrower<SPRITE> crowns) throws IOException {
/*  48 */     final int offX = json.i("OFFX", -48, 48);
/*  49 */     final int offY = json.i("OFFY", -48, 48);
/*     */     
/*  51 */     String she = json.value("FILE");
/*  52 */     if (!init.crowns.containsKey(she)) {
/*     */ 
/*     */       
/*  55 */       PATHS.ResFolder f = PATHS.RACE().folder("face").folder("addon");
/*  56 */       if (!f.sprite.exists(she)) {
/*  57 */         LOG.err(json.errorGet(String.valueOf(f.sprite.get()) + " No file named this.", she));
/*     */         
/*     */         return;
/*     */       } 
/*  61 */       TILE_SHEET tILE_SHEET = (new ComposerThings.ITileSheet(f.sprite.get(she), 104, 36)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  65 */             int FRAMES = (c.getSource()).height / 36;
/*  66 */             s.full.init(0, 0, 1, FRAMES, 5, 3, d.s8);
/*  67 */             for (int i = 0; i < FRAMES; i++)
/*  68 */               s.full.setVar(i).paste(true); 
/*  69 */             return d.s8.saveGame();
/*     */           }
/*  73 */         }).get();
/*  74 */       init.crowns.put(she, tILE_SHEET);
/*     */     } 
/*     */     
/*  77 */     int tot = 15;
/*  78 */     final TILE_SHEET sheet = (TILE_SHEET)init.crowns.get(she);
/*  79 */     int am = sheet.tiles() / 15;
/*     */ 
/*     */     
/*  82 */     for (int i = 0; i < am; i++) {
/*  83 */       final int k = i * 15;
/*  84 */       SPRITE.Imp imp = new SPRITE.Imp(40, 24)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  89 */             int t = k;
/*     */             
/*  91 */             int w = (X2 - X1) / 5;
/*  92 */             int h = (Y2 - Y1) / 3;
/*     */             
/*  94 */             int ox = offX * (X2 - X1) / 48;
/*  95 */             int oy = offY * (Y2 - Y1) / 24;
/*     */             
/*  97 */             for (int y = 0; y < 3; y++) {
/*  98 */               for (int x = 0; x < 5; x++) {
/*  99 */                 sheet.render(r, t, X1 + ox + x * w, X1 + ox + x * w + w, Y1 + oy + y * h, Y1 + oy + y * h + h);
/* 100 */                 t++;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         };
/* 105 */       crowns.add(imp);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<SPRITE> crowns() {
/* 111 */     return (LIST<SPRITE>)this.crowns;
/*     */   }
/*     */   
/*     */   public LIST<SPRITE> raiders() {
/* 115 */     return (LIST<SPRITE>)this.raiders;
/*     */   }
/*     */   
/*     */   public LIST<SPRITE> merc() {
/* 119 */     return (LIST<SPRITE>)this.merc;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RCrown.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */