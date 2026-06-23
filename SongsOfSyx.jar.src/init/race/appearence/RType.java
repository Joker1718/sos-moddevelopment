/*    */ package init.race.appearence;
/*    */ 
/*    */ import init.race.ExpandInit;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RType
/*    */ {
/*    */   public final RTypeSpec spec;
/*    */   public final RPortrait portrait;
/*    */   public final RNames names;
/*    */   public final RaceSheet sheet;
/*    */   public final TILE_SHEET sheet_skelleton;
/*    */   public final LIST<RAddon> addonsBelow;
/*    */   public final LIST<RAddon> addonsAbove;
/*    */   
/*    */   RType(RColors colors, Json json, RExtras extra, ExpandInit init) throws IOException {
/* 30 */     String ssprite = json.value("SPRITE_FILE");
/*    */ 
/*    */     
/* 33 */     if (init.map.containsKey(ssprite)) {
/* 34 */       this.sheet = (RaceSheet)init.map.get(ssprite);
/*    */     } else {
/* 36 */       this.sheet = new RaceSheet(init.sg.get(ssprite));
/* 37 */       init.map.put(ssprite, this.sheet);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 42 */     String sprite = json.value("SPRITE_SKELLETON_FILE");
/* 43 */     if (!init.skelletons.containsKey(sprite)) {
/* 44 */       this.sheet_skelleton = (new ComposerThings.ITileSheet(init.sg.getFolder("skelleton").get(sprite), 316, 120)
/*    */         {
/*    */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */           {
/* 48 */             s.singles.init(0, 0, 1, 1, 4, 3, (ComposerDests.Dest)d.s32);
/* 49 */             int a = 6;
/* 50 */             for (int i = 0; i < a; i++) {
/* 51 */               s.singles.setSkip(i * 2, 2).paste(3, true);
/*    */             }
/* 53 */             return d.s32.saveGame();
/*    */           }
/* 55 */         }).get();
/* 56 */       init.skelletons.put(sprite, this.sheet_skelleton);
/*    */     } else {
/* 58 */       this.sheet_skelleton = (TILE_SHEET)init.skelletons.get(sprite);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 63 */     this.spec = new RTypeSpec(colors, json);
/* 64 */     this.portrait = new RPortrait(init, colors, json);
/* 65 */     this.names = new RNames(json, init.names);
/*    */     
/* 67 */     LinkedList<RAddon> below = new LinkedList();
/* 68 */     LinkedList<RAddon> above = new LinkedList();
/*    */     
/* 70 */     if (json.has("ADDONS")) {
/*    */ 
/*    */       
/* 73 */       RAddon[] done = new RAddon[8]; byte b;
/*    */       int i;
/*    */       Json[] arrayOfJson;
/* 76 */       for (i = (arrayOfJson = json.jsons("ADDONS")).length, b = 0; b < i; ) { Json j = arrayOfJson[b];
/* 77 */         if (j.bool("BELOW_HEAD")) {
/* 78 */           below.add(new RAddon(j, colors, done));
/*    */         } else {
/* 80 */           above.add(new RAddon(j, colors, done));
/*    */         }  b++; }
/*    */     
/*    */     } 
/* 84 */     this.addonsAbove = (LIST<RAddon>)new ArrayList((Iterable)above);
/* 85 */     this.addonsBelow = (LIST<RAddon>)new ArrayList((Iterable)below);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class RTypeSpec
/*    */   {
/*    */     public final double occurrence;
/*    */     public final RColors.ColorCollection skin;
/*    */     public final RColors.ColorCollection leg;
/*    */     
/*    */     RTypeSpec(RColors colors, Json json) {
/* 96 */       this.occurrence = json.has("OCCURRENCE") ? json.d("OCCURRENCE") : 0.5D;
/* 97 */       this.skin = (RColors.ColorCollection)colors.collection.read("COLOR_SKIN", json);
/* 98 */       this.leg = (RColors.ColorCollection)colors.collection.read("COLOR_LEG", json);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */