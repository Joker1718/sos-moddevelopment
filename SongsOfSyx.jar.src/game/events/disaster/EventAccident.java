/*     */ package game.events.disaster;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.events.EVENTS;
/*     */ import game.time.TIME;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ECollision;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ public class EventAccident extends EVENTS.EventResource {
/*  43 */   private final double RADIUS = 1280.0D;
/*  44 */   private final Rec bounds = new Rec(2560.0D);
/*  45 */   private final VectorImp tVec = new VectorImp();
/*     */   
/*  47 */   private final ECollision coll = new ECollision();
/*     */   
/*  49 */   private static CharSequence ¤¤Accident = "¤Accident!";
/*  50 */   private static CharSequence ¤¤AccidentD = "¤An accident has occurred. {0} subjects were injured and will seek out a hospital. There were {1} deaths.";
/*  51 */   private static CharSequence ¤¤Go = "¤Go to Site";
/*     */ 
/*     */   
/*  54 */   private double[] timers = new double[SETT.ROOMS().all().size()];
/*  55 */   private double timer = 0.0D;
/*  56 */   private final double acI = this.timers.length / TIME.secondsPerDay() * 16.0D;
/*     */   
/*     */   static {
/*  59 */     D.ts(EventAccident.class);
/*     */   }
/*     */   
/*     */   public EventAccident() {
/*  63 */     super("ACCIDENTS");
/*  64 */     IDebugPanelSett.add((PLACABLE)new PlacableSimple("event: accident")
/*     */         {
/*     */           public void place(int x, int y)
/*     */           {
/*  68 */             ENTITY e = SETT.ENTITIES().getAtPoint(x, y);
/*  69 */             if (e != null && e instanceof Humanoid) {
/*  70 */               EventAccident.this.create((Humanoid)e);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int x, int y) {
/*  76 */             ENTITY e = SETT.ENTITIES().getAtPoint(x, y);
/*  77 */             if (e != null && e instanceof Humanoid) {
/*  78 */               return null;
/*     */             }
/*  80 */             return E;
/*     */           }
/*     */         });
/*     */     
/*  84 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  89 */     int i = (int)this.timer;
/*  90 */     this.timer += ds;
/*  91 */     if (i != (int)this.timer) {
/*  92 */       RoomBlueprint b = (RoomBlueprint)SETT.ROOMS().all().get(i);
/*     */       
/*  94 */       if (b instanceof RoomBlueprintIns) {
/*  95 */         RoomBlueprintIns<?> ins = (RoomBlueprintIns)b;
/*  96 */         if (b != null && b.employment() != null) {
/*     */           
/*  98 */           double emp = (b.employment().employed() - 150);
/*  99 */           if (emp < 0.0D)
/*     */             return; 
/* 101 */           emp = Math.pow(emp, 1.2D);
/*     */ 
/*     */           
/* 104 */           double c = this.acI * (b.employment()).accidentsPerYear * emp;
/* 105 */           c /= (BOOSTABLES.CIVICS()).ACCIDENT.get((BOOSTABLE_O)HCLASS_RACE.clP());
/* 106 */           c = CLAMP.d(c, 0.0D, 1.0D);
/*     */ 
/*     */           
/* 109 */           this.timers[i] = this.timers[i] - c;
/*     */ 
/*     */ 
/*     */           
/* 113 */           if (this.timers[i] < -10.0D) {
/* 114 */             create(ins);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 122 */     if (this.timer >= this.timers.length) {
/* 123 */       this.timer -= this.timers.length;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 129 */     (SETT.ROOMS()).collection.saver().save(this.timers, file);
/* 130 */     file.d(this.timer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 136 */     (SETT.ROOMS()).collection.loader().load(this.timers, file, 0.0D);
/* 137 */     this.timer = file.d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 143 */     Arrays.fill(this.timers, 0.0D);
/* 144 */     this.timer = 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean create(RoomBlueprintIns<?> b) {
/* 149 */     if (b.employment().employed() <= 0) {
/* 150 */       this.timers[b.index()] = 0.0D;
/* 151 */       return false;
/*     */     } 
/*     */     
/* 154 */     if (!MATH.isWithin(TIME.days().bitPartOf(), b.employment().getShiftStart() + 0.1D, b.employment().getShiftStart() + 0.6D)) {
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     int emp = RND.rInt(b.employment().employed());
/* 159 */     for (int i = 0; i < b.instancesSize(); i++) {
/* 160 */       RoomInstance ins = b.getInstance(i);
/* 161 */       if (ins.employees().employed() > 0) {
/* 162 */         emp -= ins.employees().employed();
/*     */         
/* 164 */         if (emp <= 0) {
/* 165 */           return create(ins);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean create(RoomInstance ins) {
/* 178 */     for (Humanoid h : ins.employees().employees()) {
/* 179 */       Room r = (Room)(STATS.WORK()).EMPLOYED.get(h);
/* 180 */       if (r != null && r.blueprint().employment() != null && r == (SETT.ROOMS()).map.get(h.tc())) {
/* 181 */         int am = create(h);
/* 182 */         this.timers[ins.blueprint().index()] = this.timers[ins.blueprint().index()] + am;
/* 183 */         return true;
/*     */       } 
/*     */     } 
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int create(Humanoid h) {
/* 194 */     Room r = (Room)(STATS.WORK()).EMPLOYED.get(h);
/* 195 */     double cx = h.body().cX() + RND.rSign();
/* 196 */     double cy = h.body().cY() + RND.rSign();
/*     */     
/* 198 */     double mom = 0.002232142857142857D + (RND.rFloat() * 2.0F) * 0.002232142857142857D;
/*     */ 
/*     */     
/* 201 */     h.inflictDamage(1.0D, CAUSE_LEAVES.getAccident());
/* 202 */     int death = 1;
/* 203 */     int inj = 0;
/*     */ 
/*     */     
/* 206 */     this.bounds.moveC(cx, cy);
/* 207 */     (SETT.THINGS()).gore.debris((int)cx, (int)cy, 0.0D, 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     for (ENTITY e : SETT.ENTITIES().fill((RECTANGLE)this.bounds)) {
/*     */       
/* 215 */       if ((SETT.ROOMS()).map.get(e.tc()) != r) {
/*     */         continue;
/*     */       }
/* 218 */       double l = this.tVec.set(cx, cy, e.body().cX(), e.body().cY());
/* 219 */       if (l > 1280.0D)
/*     */         continue; 
/* 221 */       l = 1.0D - l / 1280.0D;
/* 222 */       e.speed.setRaw(e.speed.x() + this.tVec.nX() * 64.0D * 3.0D * l, e.speed.y() + this.tVec.nY() * 64.0D * 3.0D * l);
/*     */       
/* 224 */       this.coll.dirDot = 1.0D;
/* 225 */       this.coll.tileMomentum = mom * e.physics.getMass();
/* 226 */       this.coll.damagetileStrength = 0.0D;
/* 227 */       this.coll.norX = this.tVec.nX();
/* 228 */       this.coll.norY = this.tVec.nY();
/* 229 */       this.coll.leave = CAUSE_LEAVES.getAccident();
/* 230 */       this.coll.other = null;
/* 231 */       if (e instanceof Humanoid) {
/* 232 */         Humanoid h2 = (Humanoid)e;
/* 233 */         h2.inflictDamage(l * RND.rFloat() * 2.0D, CAUSE_LEAVES.getAccident());
/* 234 */         if (e.isRemoved()) {
/* 235 */           death++; continue;
/*     */         } 
/* 237 */         if (!(STATS.NEEDS()).INJURIES.inDanger(h2.indu())) {
/* 238 */           HEvent.Handler.alertDanger(h2);
/*     */         } else {
/* 240 */           inj++;
/*     */         } 
/*     */       } 
/* 243 */       e.collide(this.coll);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     (GAME.count()).ACCIDENTS.inc(1);
/* 250 */     (new M(¤¤Accident, inj, death, h)).send();
/* 251 */     return inj + death;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class M
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final int inj;
/*     */     private final int deaths;
/*     */     private int cx;
/*     */     private int cy;
/*     */     
/*     */     public M(CharSequence title, int inj, int deaths, Humanoid h) {
/* 266 */       super(title);
/* 267 */       this.inj = inj;
/* 268 */       this.deaths = deaths;
/* 269 */       this.cx = h.tc().x();
/* 270 */       this.cy = h.tc().y();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 276 */       Str s = Str.TMP;
/* 277 */       s.clear();
/* 278 */       s.add(EventAccident.¤¤AccidentD);
/* 279 */       s.insert(0, this.inj);
/* 280 */       s.insert(1, this.deaths);
/* 281 */       paragraph((CharSequence)s);
/*     */       
/* 283 */       GButt.ButtPanel p = new GButt.ButtPanel(EventAccident.¤¤Go)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 287 */             VIEW.s().activate();
/* 288 */             (VIEW.s().getWindow()).centererTile.set(EventAccident.M.this.cx, EventAccident.M.this.cy);
/* 289 */             VIEW.messages().hide();
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 294 */       section.addRelBody(8, DIR.S, (RENDEROBJ)p);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\disaster\EventAccident.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */