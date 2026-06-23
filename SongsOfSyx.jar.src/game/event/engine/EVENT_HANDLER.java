/*     */ package game.event.engine;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import game.event.actions.EventAction;
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class EVENT_HANDLER
/*     */   extends GAME.GameResource
/*     */ {
/*  30 */   private Event current = null;
/*  31 */   private Event previous = null;
/*  32 */   private EContext data = new EContext();
/*     */   
/*     */   private final Data[] datas;
/*     */   
/*     */   private EventMessage mess;
/*     */   
/*  38 */   final KeyMap<Boolean> tags = new KeyMap();
/*     */   
/*  40 */   private Induvidual tmp = null;
/*     */   
/*     */   public EVENT_HANDLER() throws IOException {
/*  43 */     super("ENGINE");
/*  44 */     this.datas = new Data[Event.all.size()];
/*  45 */     for (int i = 0; i < this.datas.length; i++) {
/*  46 */       this.datas[i] = new Data((Event)Event.all.get(i));
/*     */     }
/*     */     
/*  49 */     GVALUES.INDU.push("NEW_ARRIVAL", Dic.¤¤newArrival, (SPRITE)(UI.icons()).s.human, new BOOLEANO<Induvidual>()
/*     */         {
/*     */           public boolean is(Induvidual t)
/*     */           {
/*  53 */             return (t == EVENT_HANDLER.this.tmp);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  62 */     if (this.current != null) {
/*  63 */       file.bool(true);
/*  64 */       file.i(this.current.allIndex);
/*  65 */       file.chars(this.current.key);
/*     */     } else {
/*  67 */       file.bool(false);
/*     */     } 
/*  69 */     if (this.previous != null) {
/*     */       
/*  71 */       file.bool(true);
/*  72 */       file.i(this.previous.allIndex);
/*  73 */       file.chars(this.previous.key);
/*     */     } else {
/*  75 */       file.bool(false);
/*     */     } 
/*     */     
/*  78 */     this.data.write(file);
/*     */     
/*  80 */     file.i(this.datas.length);
/*  81 */     for (Event k : Event.all) {
/*  82 */       file.i(k.allIndex);
/*  83 */       file.chars(k.key);
/*  84 */       file.i((this.datas[k.allIndex]).fired);
/*  85 */       file.d((this.datas[k.allIndex]).acc);
/*  86 */       file.d((this.datas[k.allIndex]).lastTime);
/*  87 */       file.bsE((this.datas[k.allIndex]).choices);
/*     */     } 
/*     */     
/*  90 */     file.i(this.tags.all().size());
/*  91 */     for (String s : this.tags.keys()) {
/*  92 */       file.chars(s);
/*  93 */       file.bool(((Boolean)this.tags.get(s)).booleanValue());
/*     */     } 
/*     */     
/*  96 */     if (this.mess != null) {
/*  97 */       file.bool(true);
/*  98 */       file.object(this.mess);
/*     */     } else {
/* 100 */       file.bool(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 107 */     clear();
/* 108 */     this.current = null;
/* 109 */     if (file.bool()) {
/* 110 */       int m = file.i();
/* 111 */       String key = file.chars();
/* 112 */       this.current = read(m, key);
/*     */     } 
/* 114 */     this.previous = null;
/* 115 */     if (file.bool()) {
/* 116 */       int m = file.i();
/* 117 */       String key = file.chars();
/* 118 */       this.previous = read(m, key);
/*     */     } 
/* 120 */     this.data = EContext.read(file);
/* 121 */     if (this.data == null) {
/* 122 */       this.data = new EContext();
/*     */     }
/*     */     
/* 125 */     int max = file.i();
/*     */     
/* 127 */     for (int i = 0; i < this.datas.length; i++) {
/* 128 */       this.datas[i] = new Data((Event)Event.all.get(i));
/*     */     }
/*     */     
/* 131 */     for (int k = 0; k < max; k++) {
/* 132 */       int m = file.i();
/* 133 */       String key = file.chars();
/* 134 */       if (m >= 0 && m < Event.all.size() && ((Event)Event.all.get(m)).key.equals(key)) {
/* 135 */         (this.datas[m]).fired = file.i();
/* 136 */         (this.datas[m]).acc = file.d();
/* 137 */         (this.datas[m]).lastTime = file.d();
/* 138 */         file.bsE((this.datas[m]).choices);
/*     */       } else {
/* 140 */         file.i();
/* 141 */         file.d();
/* 142 */         file.d();
/* 143 */         file.bsE(Alloc.bb(1));
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     this.tags.clear();
/* 148 */     int am = file.i();
/* 149 */     for (int j = 0; j < am; j++) {
/* 150 */       String str = file.chars();
/* 151 */       if (file.bool()) {
/* 152 */         this.tags.put(str, Boolean.TRUE);
/*     */       }
/*     */     } 
/* 155 */     if (file.bool()) {
/* 156 */       this.mess = (EventMessage)file.object();
/*     */     } else {
/* 158 */       this.mess = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFail() {
/* 164 */     clear();
/*     */   }
/*     */   
/*     */   private void clear() {
/* 168 */     this.current = null;
/* 169 */     this.previous = null; byte b; int i; Data[] arrayOfData;
/* 170 */     for (i = (arrayOfData = this.datas).length, b = 0; b < i; ) { Data d = arrayOfData[b];
/* 171 */       d.acc = 0.0D;
/* 172 */       d.fired = 0;
/* 173 */       d.lastTime = 0.0D;
/* 174 */       d.upI = -1;
/* 175 */       Arrays.fill(d.choices, (byte)0);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 182 */     if (this.current != null) {
/*     */       
/* 184 */       double s = timeElapsed();
/* 185 */       for (EventAction a : this.current.on_spawn) {
/* 186 */         a.update(this.current, this.data, ds, s);
/*     */       }
/*     */       
/* 189 */       for (ECondition e : this.current.aborters) {
/* 190 */         if (e.request.passes(FACTIONS.player())) {
/* 191 */           setActions(e.on_fulfill);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 197 */       if (s >= this.current.duration.seconds) {
/* 198 */         if (this.current.condition != null && this.current.condition.request.passes(FACTIONS.player())) {
/* 199 */           setActions(this.current.condition.on_fulfill);
/*     */         } else {
/* 201 */           setActions(this.current.duration.on_expire);
/*     */         } 
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setActions(LIST<EventAction> actions) {
/* 214 */     Event e = this.current;
/* 215 */     for (EventAction a : actions) {
/* 216 */       a.exe(this.current, this.data);
/*     */     }
/* 218 */     if (e == this.current)
/* 219 */       set(null, false, false, false, false); 
/*     */   }
/*     */   
/*     */   public double timeElapsed() {
/* 223 */     if (this.current != null)
/* 224 */       return TIME.currentSecond() - (this.datas[this.current.allIndex]).lastTime; 
/* 225 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public void expire() {
/* 229 */     if (this.current != null)
/* 230 */       (this.datas[this.current.allIndex]).lastTime = TIME.currentSecond() - this.current.duration.seconds - 1.0D; 
/*     */   }
/*     */   
/*     */   public boolean can(Event a) {
/* 234 */     if (!a.occurence.plockable.passes(FACTIONS.player()))
/* 235 */       return false; 
/* 236 */     int ff = (this.datas[a.allIndex]).fired;
/* 237 */     if (ff >= a.occurence.maxSpawns) {
/* 238 */       return false;
/*     */     }
/* 240 */     if (TIME.currentSecond() - (this.datas[a.allIndex]).lastTime < a.occurence.onlyAfterTime) {
/* 241 */       return false;
/*     */     }
/* 243 */     if (!a.tags.can(this.tags)) {
/* 244 */       return false;
/*     */     }
/* 246 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Event read(int index, String key) {
/* 267 */     if (index >= 0 && index < Event.all.size() && ((Event)Event.all.get(index)).key.equals(key))
/* 268 */       return (Event)Event.all.get(index); 
/* 269 */     return null;
/*     */   }
/*     */   
/*     */   public double acc(Event a) {
/* 273 */     return (this.datas[a.allIndex]).acc;
/*     */   }
/*     */   
/*     */   public void accInc(Event a) {
/* 277 */     if (can(a))
/* 278 */       (this.datas[a.allIndex]).acc += a.occurence.occurence(); 
/*     */   }
/*     */   
/*     */   public int occ(Event a) {
/* 282 */     return (this.datas[a.allIndex]).fired;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySet(Event e) {
/* 287 */     (this.datas[e.allIndex]).acc = 0.0D;
/* 288 */     if (can(e) && this.data.init(e)) {
/* 289 */       set(e, false, false, true, true);
/* 290 */       double m = 0.0D; byte b; int i; Data[] arrayOfData;
/* 291 */       for (i = (arrayOfData = this.datas).length, b = 0; b < i; ) { Data d = arrayOfData[b];
/* 292 */         m = Math.max(m, d.acc);
/*     */         b++; }
/*     */       
/* 295 */       if (m > 10000.0D)
/* 296 */         for (i = (arrayOfData = this.datas).length, b = 0; b < i; ) { Data d = arrayOfData[b];
/* 297 */           d.acc /= 2.0D;
/*     */           b++; }
/*     */          
/* 300 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 305 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Event e, boolean keepInfo, boolean keepTime, boolean clearContext, boolean message) {
/* 311 */     if (this.current != null) {
/* 312 */       byte b1; int j; String[] arrayOfString1; for (j = (arrayOfString1 = this.current.tags.removes).length, b1 = 0; b1 < j; ) { String s = arrayOfString1[b1];
/* 313 */         this.tags.putReplace(s, Boolean.FALSE);
/*     */         b1++; }
/*     */     
/*     */     } 
/* 317 */     if (e == null) {
/* 318 */       this.current = null;
/*     */       
/*     */       return;
/*     */     } 
/* 322 */     if (clearContext || e == null) {
/* 323 */       this.data.init(e);
/* 324 */     } else if (e != null) {
/* 325 */       this.data.initLight(e);
/*     */     } 
/*     */     
/* 328 */     if (!keepTime) {
/* 329 */       (this.datas[e.allIndex]).lastTime = TIME.currentSecond();
/*     */     } else {
/* 331 */       (this.datas[e.allIndex]).lastTime = (this.datas[this.current.allIndex]).lastTime;
/* 332 */     }  if (!keepInfo) {
/* 333 */       this.previous = this.current;
/*     */     }
/*     */ 
/*     */     
/* 337 */     this.current = e; byte b; int i; String[] arrayOfString;
/* 338 */     for (i = (arrayOfString = this.current.tags.adds).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 339 */       this.tags.putReplace(s, Boolean.TRUE); b++; }
/*     */     
/* 341 */     (this.datas[e.allIndex]).fired++;
/*     */     
/* 343 */     (this.datas[e.allIndex]).acc = 0.0D;
/* 344 */     if ((this.datas[e.allIndex]).upI == GAME.updateI()) {
/* 345 */       throw new Errors.DataError("An event is creating an infinate loop! " + e.key);
/*     */     }
/* 347 */     (this.datas[e.allIndex]).upI = GAME.updateI();
/*     */     
/* 349 */     if (message && this.current.info.messages.length > 0) {
/*     */       
/* 351 */       this.mess = new EventMessage(e, this.data);
/* 352 */       this.mess.send();
/*     */     } else {
/* 354 */       this.mess = null;
/*     */     } 
/*     */     
/* 357 */     for (EventAction a : e.on_spawn) {
/* 358 */       a.exe(this.current, this.data);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTmp(Event e) {
/* 369 */     EContext data = new EContext();
/* 370 */     data.init(e);
/*     */     
/* 372 */     (this.datas[e.allIndex]).lastTime = TIME.currentSecond();
/* 373 */     (this.datas[e.allIndex]).fired++;
/*     */     
/* 375 */     (this.datas[e.allIndex]).acc = 0.0D;
/* 376 */     if ((this.datas[e.allIndex]).upI == GAME.updateI()) {
/* 377 */       throw new Errors.DataError("An event is creating an infinate loop! " + e.key);
/*     */     }
/* 379 */     (this.datas[e.allIndex]).upI = GAME.updateI();
/*     */     
/* 381 */     if (e.info.messages.length > 0) {
/* 382 */       (new EventMessage(e, data)).send();
/*     */     }
/*     */     
/* 385 */     for (EventAction a : e.on_spawn)
/* 386 */       a.exe(this.current, data); 
/*     */   }
/*     */   
/*     */   public Event current() {
/* 390 */     return this.current;
/*     */   }
/*     */   
/*     */   public EventMessage mess() {
/* 394 */     return this.mess;
/*     */   }
/*     */   
/*     */   EContext context() {
/* 398 */     return this.data;
/*     */   }
/*     */   
/*     */   private class Data {
/*     */     double acc;
/*     */     double lastTime;
/*     */     int fired;
/* 405 */     int upI = -1;
/*     */     final byte[] choices;
/*     */     
/*     */     Data(Event e) {
/* 409 */       this.choices = Alloc.bb(e.choices.size());
/*     */     }
/*     */   }
/*     */   
/*     */   public CLICKABLE butt() {
/* 414 */     return (CLICKABLE)new Butt(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR color(Induvidual in) {
/* 419 */     if (this.current != null) {
/* 420 */       if (STATS.EVENT().has(in))
/* 421 */         return (COLOR)this.data.colorIndu; 
/* 422 */       return (COLOR)this.data.colorinduAll;
/*     */     } 
/* 424 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence message(Induvidual in) {
/* 429 */     if (this.current != null && this.current.info.subject.length() > 0 && 
/* 430 */       STATS.EVENT().has(in)) {
/* 431 */       return this.current.info.subject;
/*     */     }
/* 433 */     return null;
/*     */   }
/*     */   
/*     */   public boolean shouldSet(Induvidual i) {
/* 437 */     this.tmp = i;
/* 438 */     if (this.current != null && this.current.selection.indu.filters.size() > 0 && this.data.indu.am < this.data.indu.max)
/* 439 */       for (Lockable<Induvidual> l : this.current.selection.indu.filters) {
/* 440 */         if (l.passes(i)) {
/* 441 */           this.data.indu.am++;
/* 442 */           return true;
/*     */         } 
/*     */       }  
/* 445 */     this.tmp = null;
/* 446 */     return false;
/*     */   }
/*     */   
/*     */   public boolean choiceHasBeenSelected(Event parent, int choice) {
/* 450 */     Data d = this.datas[parent.allIndex];
/* 451 */     if (choice >= 0 && choice < d.choices.length)
/* 452 */       return (d.choices[choice] > 0); 
/* 453 */     return false;
/*     */   }
/*     */   
/*     */   void choiceSelect(Event parent, int choice) {
/* 457 */     Data d = this.datas[parent.allIndex];
/* 458 */     d.choices[choice] = (byte)(d.choices[choice] + 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EVENT_HANDLER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */