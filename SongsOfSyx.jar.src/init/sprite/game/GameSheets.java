/*     */ package init.sprite.game;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ 
/*     */ 
/*     */ public class GameSheets
/*     */ {
/*  16 */   private final Sheet[] overlays = new Sheet[SheetType.ALL.size()];
/*     */   private final LIST<KeyMap<LIST<Sheet>>> gsheets;
/*     */   private final LIST<KeyMap<LIST<TILE_SHEET>>> raws;
/*  19 */   final KeyMap<SheetType> imap = new KeyMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean[] adump;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<TILE_SHEET> raws(SheetType t, String file, Json error) throws IOException {
/*  46 */     if (((KeyMap)this.raws.get(t.index())).containsKey(file)) {
/*  47 */       return (LIST<TILE_SHEET>)((KeyMap)this.raws.get(t.index())).get(file);
/*     */     }
/*  49 */     LIST<TILE_SHEET> sh = t.make(file, error);
/*  50 */     ((KeyMap)this.raws.get(t.index())).put(file, sh);
/*     */     
/*  52 */     ArrayList<Sheet> res = new ArrayList(sh.size());
/*  53 */     for (TILE_SHEET s : sh) {
/*  54 */       res.add(new Sheet.Imp(t, s, true));
/*     */     }
/*  56 */     ((KeyMap)this.gsheets.get(t.index())).put(file, res);
/*     */     
/*  58 */     return sh;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_SHEET raw(SheetType t, Json json) throws IOException {
/*  63 */     json = json.json("GAME_TEXTURE");
/*  64 */     String file = json.value("FILE");
/*  65 */     int row = json.i("ROW");
/*  66 */     return raw(t, file, row, json);
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_SHEET raw(SheetType t, String key, Json json) throws IOException {
/*  71 */     json = json.json(key);
/*  72 */     String file = json.value("FILE");
/*  73 */     int row = json.i("ROW");
/*  74 */     return raw(t, file, row, json);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_SHEET raw(SheetType t, String file, int row, Json error) throws IOException {
/*  80 */     LIST<TILE_SHEET> li = raws(t, file, error);
/*     */     
/*  82 */     if (row >= li.size()) {
/*  83 */       if (error != null)
/*  84 */         GAME.WarnLight("" + row + "is outside of the available sprites. In + file " + row); 
/*  85 */       return SheetType.DUMMY;
/*     */     } 
/*  87 */     return (TILE_SHEET)li.get(row);
/*     */   }
/*     */ 
/*     */   
/*     */   public Sheet overlay(SheetType t) {
/*  92 */     return this.overlays[t.index()];
/*     */   }
/*     */   
/*     */   public LIST<Sheet> sheets(SheetType t, String file, Json error) throws IOException {
/*  96 */     if (((KeyMap)this.gsheets.get(t.index())).containsKey(file))
/*  97 */       return (LIST<Sheet>)((KeyMap)this.gsheets.get(t.index())).get(file); 
/*  98 */     raws(t, file, error);
/*  99 */     LIST<Sheet> ss = (LIST<Sheet>)((KeyMap)this.gsheets.get(t.index())).get(file);
/*     */     
/* 101 */     return ss;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(SheetType t, LIST<Sheet> sh, String key) {
/* 106 */     if (((KeyMap)this.gsheets.get(t.index())).containsKey(key)) {
/* 107 */       throw new RuntimeException(key);
/*     */     }
/* 109 */     ((KeyMap)this.gsheets.get(t.index())).put(key, sh);
/*     */   }
/*     */   
/* 112 */   public GameSheets() throws IOException { this.adump = new boolean[SheetType.ALL.size()]; ArrayList<KeyMap<LIST<Sheet>>> m = new ArrayList(SheetType.ALL.size()); ArrayList<KeyMap<LIST<TILE_SHEET>>> r = new ArrayList(SheetType.ALL.size()); this.gsheets = (LIST<KeyMap<LIST<Sheet>>>)m; this.raws = (LIST<KeyMap<LIST<TILE_SHEET>>>)r; for (SheetType t : SheetType.ALL) { this.imap.put(t.path, t); m.add(new KeyMap()); r.add(new KeyMap()); }  for (SheetType t : SheetType.ALL) { if (t == SheetType.sCombo)
/*     */         continue;  if (t == SheetType.sBox)
/*     */         continue;  if (t == SheetType.sTex)
/* 115 */         continue;  this.overlays[t.index()] = (Sheet)sheets(t, "_OVERLAY", null).get(0); }  } public LIST<SheetPair> sheets(SheetType type, Json json) throws IOException { String[] ss = json.values("FRAMES");
/*     */     
/* 117 */     SheetData[] datas = new SheetData[ss.length];
/*     */     
/* 119 */     SheetData odata = new SheetData(json);
/* 120 */     for (int j = 0; j < datas.length; j++) {
/* 121 */       datas[j] = odata;
/*     */     }
/* 123 */     if (json.has("OVERWRITE")) {
/* 124 */       Json[] js = json.jsons("OVERWRITE");
/* 125 */       for (int m = 0; m < datas.length && m < js.length; m++)
/*     */       {
/* 127 */         datas[m] = new SheetData(odata, js[m]);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     int i = 0;
/* 136 */     ArrayList<SheetPair> sheets = new ArrayList(ss.length); byte b; int k;
/*     */     String[] arrayOfString1;
/* 138 */     for (k = (arrayOfString1 = ss).length, b = 0; b < k; ) { String str1 = arrayOfString1[b];
/*     */       
/* 140 */       SheetData data = datas[i++];
/*     */       
/* 142 */       if (str1.equals("-")) {
/* 143 */         sheets.add(new SheetPair(type.dummy(), data));
/*     */         
/*     */         continue;
/*     */       } 
/* 147 */       String[] chops = str1.split(":");
/*     */       
/* 149 */       if (chops.length != 2) {
/* 150 */         json.error("malformatted frame. Format is FILENAME:ROW Current is: " + str1, str1);
/*     */       }
/*     */       
/* 153 */       String file = chops[0].trim();
/* 154 */       String snr = chops[1].trim();
/*     */       
/* 156 */       PATH p = PATHS.SPRITE_GAME().getFolder(type.path);
/*     */       
/* 158 */       if (!((KeyMap)this.gsheets.get(type.index())).containsKey(file))
/*     */       {
/*     */         
/* 161 */         if (!p.exists(file)) {
/* 162 */           String a = "";
/* 163 */           if (!this.adump[type.index()]) {
/* 164 */             a = System.lineSeparator() + "Available: ";
/* 165 */             this.adump[type.index()] = true;
/* 166 */             for (String ke : ((KeyMap)this.gsheets.get(type.index())).keys())
/* 167 */               a = a + a + System.lineSeparator();  byte b1; int m;
/*     */             String[] arrayOfString;
/* 169 */             for (m = (arrayOfString = p.getFiles()).length, b1 = 0; b1 < m; ) { String ke = arrayOfString[b1];
/* 170 */               if (!((KeyMap)this.gsheets.get(type.index())).containsKey(ke)) {
/* 171 */                 a = a + a + System.lineSeparator();
/*     */               }
/*     */               b1++; }
/*     */           
/*     */           } 
/* 176 */           GAME.WarnLight(String.valueOf(p.get()) + "/" + String.valueOf(p.get()) + " does not exist and will be ignored. Refrenced from: " + file + json.path());
/*     */           continue;
/*     */         } 
/*     */       }
/* 180 */       LIST<Sheet> shs = sheets(type, file, json);
/*     */       
/* 182 */       int nr = 0;
/*     */       try {
/* 184 */         nr = Integer.parseInt(snr);
/* 185 */       } catch (Exception e) {
/* 186 */         json.error("malformatted Row. Format is FOLDER:FILENAME:ROW", str1);
/*     */       } 
/*     */ 
/*     */       
/* 190 */       if (nr < 0 || nr >= shs.size()) {
/* 191 */         GAME.WarnLight("ROW: " + nr + " in file: " + String.valueOf(p.get(file)) + " is out of bounds. must specify a row of the image: " + json.path());
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 196 */         sheets.add(new SheetPair((Sheet)shs.get(nr), data));
/*     */       }  continue; b++; }
/*     */     
/* 199 */     return (LIST<SheetPair>)new ArrayList((Iterable)sheets); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\game\GameSheets.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */