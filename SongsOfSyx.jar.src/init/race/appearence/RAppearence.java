/*     */ package init.race.appearence;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.race.ExpandInit;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import world.map.regions.centre.WorldRaceSheet;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RAppearence
/*     */ {
/*     */   public final RColors colors;
/*     */   public final Icon icon;
/*     */   public final Icon iconBig;
/*     */   public final TILE_SHEET sleep;
/*     */   public final RExtras extra;
/*     */   public final int off;
/*     */   public final LIST<String> lastNamesNoble;
/*     */   public final RFloors floors;
/*     */   public final RCrown crown;
/*     */   public final RType child;
/*     */   public final TILE_SHEET infant;
/*     */   public final LIST<RType> types;
/*     */   public double tMax;
/*     */   public final WorldRaceSheet world;
/*     */   
/*     */   public RAppearence(Race race, Json data, ExpandInit init, int hitboxSize) throws IOException {
/*  44 */     this.icon = SPRITES.icons().get(data, "ICON_SMALL");
/*  45 */     this.iconBig = SPRITES.icons().get(data, "ICON_BIG");
/*  46 */     this.floors = new RFloors(data);
/*  47 */     data = new Json((PATHS.RACE()).init.getFolder("sprite").gets(data.value("SPRITE_FILE")));
/*  48 */     this.colors = new RColors(data);
/*     */     
/*  50 */     this.lastNamesNoble = (LIST<String>)RNames.names("NAMESET_FILE_NOBLE", data, init.names);
/*     */     
/*  52 */     this.world = new WorldRaceSheet(data.json("WORLD"));
/*     */     
/*  54 */     String s = data.value("SPRITE_EXTRA_FILE");
/*  55 */     if (init.extras.containsKey(s)) {
/*  56 */       this.extra = (RExtras)init.extras.get(s);
/*     */     } else {
/*  58 */       this.extra = new RExtras(init.sg.getFolder("extra").get(s));
/*  59 */       init.extras.put(s, this.extra);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  64 */     String ssleep = data.value("SLEEP_FILE");
/*  65 */     if (init.sleep.containsKey(ssleep)) {
/*  66 */       this.sleep = (TILE_SHEET)init.sleep.get(ssleep);
/*     */     } else {
/*     */       
/*  69 */       this.sleep = (new ComposerThings.ITileSheet(init.sg.getFolder("sleep").get(ssleep), 164, 44)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  73 */             int am = (c.getSource()).height / 38;
/*  74 */             s.singles.init(0, 0, 1, 1, 2, am, (ComposerDests.Dest)d.s32);
/*  75 */             for (int i = 0; i < am; i++) {
/*  76 */               s.singles.setSkip(i * 2, 2).paste(3, true);
/*     */             }
/*  78 */             return d.s32.saveGame();
/*     */           }
/*  80 */         }).get();
/*     */       
/*  82 */       init.sleep.put(ssleep, this.sleep);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  87 */     this.crown = new RCrown(init, data);
/*     */ 
/*     */     
/*  90 */     Json jchild = data.json("CHILD");
/*     */     
/*  92 */     this.child = new RType(this.colors, jchild, this.extra, init);
/*     */     
/*  94 */     if (jchild.has("INFANT_FILE")) {
/*  95 */       String key = jchild.value("INFANT_FILE");
/*  96 */       if (init.infants.containsKey(key)) {
/*  97 */         this.infant = (TILE_SHEET)init.infants.get(key);
/*     */       } else {
/*     */         
/* 100 */         this.infant = (new ComposerThings.ITileSheet(init.sg.getFolder("infant").get(key), 352, 22)
/*     */           {
/*     */             
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 105 */               s.full2.init(0, 0, 8, 1, 1, 1, d.s16);
/*     */               
/* 107 */               for (int i = 0; i < 4; i++) {
/* 108 */                 int k; for (k = 0; k < 4; k++) {
/* 109 */                   s.full2.setVar(4 + k).pasteRotated(i, true);
/*     */                 }
/* 111 */                 for (k = 0; k < 4; k++) {
/* 112 */                   s.full2.setVar(k).pasteRotated((i + 1) % 4, true);
/*     */                 }
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 118 */               return d.s16.saveGame();
/*     */             }
/* 120 */           }).get();
/*     */         
/* 122 */         init.infants.put(key, this.infant);
/*     */       } 
/*     */     } else {
/* 125 */       this.infant = TILE_SHEET.DUMMY;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 130 */     Json[] jjs = data.jsons("TYPES", 1, 4);
/*     */     
/* 132 */     ArrayList<RType> types = new ArrayList(jjs.length); byte b; int i;
/*     */     Json[] arrayOfJson1;
/* 134 */     for (i = (arrayOfJson1 = jjs).length, b = 0; b < i; ) { Json j = arrayOfJson1[b];
/* 135 */       types.add(new RType(this.colors, j, this.extra, init));
/*     */       b++; }
/*     */     
/* 138 */     this.types = (LIST<RType>)types;
/*     */ 
/*     */     
/* 141 */     double bb = 0.0D;
/* 142 */     for (RType t : this.types) {
/* 143 */       bb += t.spec.occurrence;
/*     */     }
/* 145 */     this.tMax = bb;
/*     */     
/* 147 */     this.off = (((RType)this.types.get(0)).sheet.sheet.size() - hitboxSize) / 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RType adult() {
/* 154 */     return (RType)this.types.get(0);
/*     */   }
/*     */   
/*     */   public RType child() {
/* 158 */     return this.child;
/*     */   }
/*     */   
/*     */   public RType sheet(Induvidual indu) {
/* 162 */     return (indu.hType().parent() != indu.hType()) ? this.child : (RType)this.types.getC((STATS.APPEARANCE()).gender.get(indu));
/*     */   }
/*     */   
/*     */   public RType sheet(int gender) {
/* 166 */     return (RType)this.types.getC(gender);
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_SHEET skelleton(Induvidual indu) {
/* 171 */     return (sheet(indu)).sheet_skelleton;
/*     */   }
/*     */   
/*     */   public TILE_SHEET skelleton(boolean adult) {
/* 175 */     return !adult ? ((RType)this.types.get(0)).sheet_skelleton : this.child.sheet_skelleton;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBaby(SPRITE_RENDERER r, int cx, int cy, int rot, int ran) {
/* 180 */     int frame = (int)(ran + TIME.currentSecond() * 4.0D);
/* 181 */     if ((frame >> 6 & 0x3) != 0) {
/* 182 */       frame = ran;
/*     */     }
/*     */     
/* 185 */     frame &= 0x3;
/* 186 */     rot *= 4;
/* 187 */     int x = cx - this.infant.size() / 2;
/* 188 */     int y = cy - this.infant.size() / 2;
/* 189 */     this.infant.render(r, frame + rot, x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RAppearence.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */