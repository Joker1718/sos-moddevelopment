/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import init.value.Lockers;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.ui.message.MessageSection;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PLevels
/*     */ {
/*  45 */   private static CharSequence ¤¤mTitle = "¤New level unlocked!";
/*  46 */   private static CharSequence ¤¤mMessage = "¤A new level has been bestowed upon your name!"; public final INFO info; private final ArrayList<Level> levels; private Level current; private boolean increase; public final BoostSpecs boosters; private final BoostCompound<Level> bos; private double time; final SAVABLE saver;
/*     */   
/*  48 */   public PLevels() { D.t(this);
/*     */ 
/*     */     
/*  51 */     this.info = new INFO(
/*  52 */         D.g("Level"), 
/*  53 */         D.g("Desc", "As you grow in might and population, titles will be bestowed upon your name. Levels will unlock great advantages to a ruler."));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 111 */           file.i(PLevels.this.current.index);
/* 112 */           file.d(PLevels.this.time);
/*     */         } public void exe() { PLevels.this.increase = true;
/*     */           PLevels.this.time = TIME.secondsPerDay(); } protected double getValue(PLevels.Level t) { return ((PLevels.this.current.index >= t.index) ? true : false); } });
/*     */   this.boosters = new BoostSpecs(Dic.¤¤Level, (SPRITE)(UI.icons()).s.star, true);
/*     */   this.bos = new BoostCompound<Level>(this.boosters, (LIST)this.levels) {
/* 117 */       public void load(FileGetter file) throws IOException { int i = file.i();
/* 118 */         if (i >= PLevels.this.levels.size())
/* 119 */           i = PLevels.this.levels.size() - 1; 
/* 120 */         PLevels.this.current = (PLevels.Level)PLevels.this.levels.get(i);
/*     */         
/* 122 */         PLevels.this.bos.clearChache();
/* 123 */         PLevels.this.time = file.d(); } }; PATH data = PATHS.INIT().getFolder("player").getFolder("level"); PATH text = PATHS.TEXT().getFolder("player").getFolder("level"); String[] ss = data.getFiles(); this.levels = new ArrayList(ss.length); byte b; int i; String[] arrayOfString1; for (i = (arrayOfString1 = ss).length, b = 0; b < i; ) {
/*     */     String s = arrayOfString1[b]; b++;
/*     */   } 
/*     */   if (this.levels.size() == 0);
/*     */   this.current = (Level)this.levels.get(0);
/* 128 */   IDebugPanel.add("Increase level", new ACTION() { public void clear() { PLevels.this.current = (PLevels.Level)PLevels.this.levels.get(0);
/* 129 */           PLevels.this.bos.clearChache();
/* 130 */           PLevels.this.time = 0.0D; } protected BoostSpecs bos(PLevels.Level t) {
/*     */           return t.boosters;
/*     */         }
/*     */       }; }
/*     */    void update(double ds) {
/* 135 */     if (current().index() < this.levels.size() - 1 && (this.increase || ((Level)this.levels.get(current().index() + 1)).lockable.passes(FACTIONS.player()))) {
/* 136 */       this.time += ds;
/* 137 */       if (this.time > TIME.secondsPerDay()) {
/* 138 */         this.current = (Level)this.levels.get(current().index() + 1);
/* 139 */         this.bos.clearChache();
/* 140 */         (new Mess(this.current.index)).send();
/* 141 */         this.increase = false;
/*     */       } 
/*     */     } else {
/* 144 */       this.time = TIME.currentSecond();
/*     */     } 
/*     */   }
/*     */   
/*     */   public LIST<Level> all() {
/* 149 */     return (LIST<Level>)this.levels;
/*     */   }
/*     */   
/*     */   public Level current() {
/* 153 */     return this.current;
/*     */   }
/*     */   
/*     */   public void set(int level) {
/* 157 */     this.current = (Level)this.levels.get(level);
/*     */   }
/*     */   
/*     */   public static class Level
/*     */     implements INDEXED
/*     */   {
/*     */     private final int index;
/*     */     public final CharSequence male;
/*     */     public final CharSequence female;
/*     */     public final CharSequence desc;
/*     */     public final BoostSpecs boosters;
/*     */     public final Lockable<Faction> lockable;
/*     */     public final Lockers lockers;
/*     */     
/*     */     Level(ArrayList<Level> all, String key, PATH data, PATH text) {
/* 172 */       this.index = all.add(this);
/* 173 */       Json d = new Json(data.gets(key));
/* 174 */       Json t = new Json(text.gets(key));
/* 175 */       this.male = t.text("MALE");
/* 176 */       this.female = t.text("FEMALE");
/* 177 */       this.desc = t.text("DESC");
/*     */       
/* 179 */       this.lockable = GVALUES.FACTION.LOCK.push();
/* 180 */       this.lockable.push(d);
/* 181 */       this.lockers = new Lockers(String.valueOf(Dic.¤¤Level) + ": " + String.valueOf(Dic.¤¤Level), (SPRITE)(UI.icons()).s.star);
/*     */       
/* 183 */       this.lockers.add(GVALUES.FACTION, d, new DOUBLE_O<Faction>()
/*     */           {
/*     */             
/*     */             public double getD(Faction t)
/*     */             {
/* 188 */               if (t == FACTIONS.player()) {
/* 189 */                 if (FACTIONS.player().level().current().index() >= PLevels.Level.this.index())
/* 190 */                   return 1.0D; 
/* 191 */                 return 0.0D;
/*     */               } 
/* 193 */               return 1.0D;
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 198 */       this.lockers.add(GVALUES.INDU, d, new DOUBLE_O<Induvidual>()
/*     */           {
/*     */             public double getD(Induvidual t)
/*     */             {
/* 202 */               if (t.faction() == FACTIONS.player()) {
/* 203 */                 if (FACTIONS.player().level().current().index() >= PLevels.Level.this.index())
/* 204 */                   return 1.0D; 
/* 205 */                 return 0.0D;
/*     */               } 
/* 207 */               return 1.0D;
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 212 */       this.lockers.add(GVALUES.REGION, d, new DOUBLE_O<Region>()
/*     */           {
/*     */             public double getD(Region t)
/*     */             {
/* 216 */               if (t.faction() == FACTIONS.player()) {
/* 217 */                 if (FACTIONS.player().level().current().index() >= PLevels.Level.this.index())
/* 218 */                   return 1.0D; 
/* 219 */                 return 0.0D;
/*     */               } 
/* 221 */               return 1.0D;
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 226 */       this.boosters = new BoostSpecs(String.valueOf(Dic.¤¤Level) + ": " + String.valueOf(Dic.¤¤Level), (SPRITE)(UI.icons()).s.star, false);
/* 227 */       this.boosters.read(d, null);
/*     */     }
/*     */     
/*     */     public CharSequence name() {
/* 231 */       return this.male;
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 236 */       return this.index;
/*     */     }
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 240 */       GBox b = (GBox)text;
/* 241 */       b.title(name());
/* 242 */       GText t = b.text();
/* 243 */       t.add(this.desc);
/* 244 */       b.add((SPRITE)t);
/* 245 */       b.NL(4);
/*     */       
/* 247 */       this.lockable.hover(text, FACTIONS.player());
/* 248 */       b.sep();
/* 249 */       this.lockers.hover(text);
/* 250 */       b.NL(8);
/* 251 */       this.boosters.hover(text, 1.0D, -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Mess
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final int lev;
/*     */ 
/*     */     
/*     */     public Mess(int lev) {
/* 265 */       super(PLevels.¤¤mTitle);
/* 266 */       this.lev = lev;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 273 */       final PLevels.Level l = (PLevels.Level)FACTIONS.player().level().all().get(this.lev);
/* 274 */       paragraph(PLevels.¤¤mMessage);
/* 275 */       section.addRelBody(16, DIR.S, (RENDEROBJ)new GHeader(l.name()));
/*     */       
/* 277 */       section.addRelBody(8, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(700, (GBox.Dummy()).maxHeight)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 281 */               GBox.tmp.clear();
/* 282 */               GBox.tmp.maxWidth = 700;
/* 283 */               GBox.tmp.maxHeight = 500;
/* 284 */               l.hoverInfoGet((GUI_BOX)GBox.tmp);
/* 285 */               GBox.tmp.renderWithout(r, this.body.x1(), this.body.y1());
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PLevels.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */