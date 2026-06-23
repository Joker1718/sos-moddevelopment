/*     */ package world.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LIST;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
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
/*     */ class null
/*     */   extends WORLD.WorldResourceManager
/*     */ {
/*     */   public void save(FilePutter file) {
/* 160 */     RD.this.init.count.saver().save(WORLD.REGIONS().all(), file);
/* 161 */     RD.this.init.rCount.saver().save(FACTIONS.all(), file);
/*     */     
/* 163 */     file.isE(RD.this.factionI); byte b; int i;
/*     */     Realm[] arrayOfRealm;
/* 165 */     for (i = (arrayOfRealm = RD.this.drea).length, b = 0; b < i; ) { Realm r = arrayOfRealm[b];
/* 166 */       r.saver.save(file); b++; }
/*     */     
/* 168 */     for (SAVABLE s : RD.this.init.savable) {
/* 169 */       s.save(file);
/*     */     }
/* 171 */     RD.this.updater.saver.save(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 177 */     RD.this.init.count.loader().load(WORLD.REGIONS().all(), file);
/* 178 */     RD.this.init.rCount.loader().load(FACTIONS.all(), file);
/*     */     
/* 180 */     file.isE(RD.this.factionI); byte b; int i;
/*     */     Realm[] arrayOfRealm;
/* 182 */     for (i = (arrayOfRealm = RD.this.drea).length, b = 0; b < i; ) { Realm r = arrayOfRealm[b];
/* 183 */       r.saver.load(file);
/*     */       b++; }
/*     */     
/* 186 */     for (SAVABLE s : RD.this.init.savable) {
/* 187 */       s.load(file);
/*     */     }
/* 189 */     RD.this.updater.saver.load(file);
/* 190 */     (RD.BUILDINGS()).costs.setDirty();
/*     */   } public void clear() {
/*     */     byte b;
/*     */     int i;
/*     */     long[][] arrayOfLong;
/* 195 */     for (i = (arrayOfLong = RD.this.regionData).length, b = 0; b < i; ) { long[] r = arrayOfLong[b];
/* 196 */       Arrays.fill(r, 0L); b++; }
/*     */     
/* 198 */     for (i = (arrayOfLong = RD.this.factionData).length, b = 0; b < i; ) { long[] r = arrayOfLong[b];
/* 199 */       Arrays.fill(r, 0L); b++; }
/*     */     
/*     */     Realm[] arrayOfRealm;
/* 202 */     for (i = (arrayOfRealm = RD.this.drea).length, b = 0; b < i; ) { Realm r = arrayOfRealm[b];
/* 203 */       r.saver.clear();
/*     */       b++; }
/*     */     
/* 206 */     Arrays.fill(RD.this.factionI, -1);
/*     */     
/* 208 */     for (SAVABLE s : RD.this.init.savable)
/* 209 */       s.clear(); 
/* 210 */     RD.this.updater.saver.clear();
/* 211 */     WORLD.MINIMAP().repaint();
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 216 */     return (LIST<PLACABLE>)new Placers();
/*     */   }
/*     */ 
/*     */   
/*     */   public void generate(ACTION loadPrint) {
/* 221 */     clear();
/*     */ 
/*     */ 
/*     */     
/* 225 */     loadPrint.exe();
/* 226 */     RD.this.prime();
/* 227 */     loadPrint.exe();
/*     */   }
/*     */ 
/*     */   
/*     */   public void validateInit(WORLD.WorldError error) {
/* 232 */     if (!(WORLD.REGIONS()).player.active()) {
/* 233 */       error.problem = "Player region is missing";
/* 234 */       error.coo.set(-1.0D, -1.0D);
/*     */       
/*     */       return;
/*     */     } 
/* 238 */     (WORLD.REGIONS()).player.fationSet((Faction)FACTIONS.player(), false);
/* 239 */     (WORLD.REGIONS()).player.setCapitol();
/* 240 */     (WORLD.REGIONS()).player.info.name().clear().add((CharSequence)(FACTIONS.player()).name);
/*     */     
/* 242 */     if (FACTIONS.NPCs().size() == 0)
/* 243 */       error.warning = "No factions have been set"; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RD$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */