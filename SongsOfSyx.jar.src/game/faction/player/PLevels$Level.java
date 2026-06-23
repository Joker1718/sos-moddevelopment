/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.paths.PATH;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import init.value.Lockers;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
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
/*     */ public class Level
/*     */   implements INDEXED
/*     */ {
/*     */   private final int index;
/*     */   public final CharSequence male;
/*     */   public final CharSequence female;
/*     */   public final CharSequence desc;
/*     */   public final BoostSpecs boosters;
/*     */   public final Lockable<Faction> lockable;
/*     */   public final Lockers lockers;
/*     */   
/*     */   Level(ArrayList<Level> all, String key, PATH data, PATH text) {
/* 172 */     this.index = all.add(this);
/* 173 */     Json d = new Json(data.gets(key));
/* 174 */     Json t = new Json(text.gets(key));
/* 175 */     this.male = t.text("MALE");
/* 176 */     this.female = t.text("FEMALE");
/* 177 */     this.desc = t.text("DESC");
/*     */     
/* 179 */     this.lockable = GVALUES.FACTION.LOCK.push();
/* 180 */     this.lockable.push(d);
/* 181 */     this.lockers = new Lockers(String.valueOf(Dic.¤¤Level) + ": " + String.valueOf(Dic.¤¤Level), (SPRITE)(UI.icons()).s.star);
/*     */     
/* 183 */     this.lockers.add(GVALUES.FACTION, d, new DOUBLE_O<Faction>()
/*     */         {
/*     */           
/*     */           public double getD(Faction t)
/*     */           {
/* 188 */             if (t == FACTIONS.player()) {
/* 189 */               if (FACTIONS.player().level().current().index() >= PLevels.Level.this.index())
/* 190 */                 return 1.0D; 
/* 191 */               return 0.0D;
/*     */             } 
/* 193 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 198 */     this.lockers.add(GVALUES.INDU, d, new DOUBLE_O<Induvidual>()
/*     */         {
/*     */           public double getD(Induvidual t)
/*     */           {
/* 202 */             if (t.faction() == FACTIONS.player()) {
/* 203 */               if (FACTIONS.player().level().current().index() >= PLevels.Level.this.index())
/* 204 */                 return 1.0D; 
/* 205 */               return 0.0D;
/*     */             } 
/* 207 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 212 */     this.lockers.add(GVALUES.REGION, d, new DOUBLE_O<Region>()
/*     */         {
/*     */           public double getD(Region t)
/*     */           {
/* 216 */             if (t.faction() == FACTIONS.player()) {
/* 217 */               if (FACTIONS.player().level().current().index() >= PLevels.Level.this.index())
/* 218 */                 return 1.0D; 
/* 219 */               return 0.0D;
/*     */             } 
/* 221 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 226 */     this.boosters = new BoostSpecs(String.valueOf(Dic.¤¤Level) + ": " + String.valueOf(Dic.¤¤Level), (SPRITE)(UI.icons()).s.star, false);
/* 227 */     this.boosters.read(d, null);
/*     */   }
/*     */   
/*     */   public CharSequence name() {
/* 231 */     return this.male;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 236 */     return this.index;
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 240 */     GBox b = (GBox)text;
/* 241 */     b.title(name());
/* 242 */     GText t = b.text();
/* 243 */     t.add(this.desc);
/* 244 */     b.add((SPRITE)t);
/* 245 */     b.NL(4);
/*     */     
/* 247 */     this.lockable.hover(text, FACTIONS.player());
/* 248 */     b.sep();
/* 249 */     this.lockers.hover(text);
/* 250 */     b.NL(8);
/* 251 */     this.boosters.hover(text, 1.0D, -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PLevels$Level.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */