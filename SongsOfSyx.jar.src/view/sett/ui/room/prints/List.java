/*     */ package view.sett.ui.room.prints;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.copy.SavedPrints;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class List {
/*  16 */   private final Cat[] catmap = new Cat[SETT.ROOMS().all().size()];
/*  17 */   private final ArrayListGrower<Cat> cats = new ArrayListGrower();
/*  18 */   private ArrayList<Entry> free = new ArrayList((Object[])new Entry[0]);
/*  19 */   private ArrayList<Entry> current = new ArrayList((Object[])new Entry[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StringInputSprite filter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int vi;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List(StringInputSprite filter) {
/*  45 */     this.vi = -1; this.filter = filter; for (RoomBlueprintImp b : SETT.ROOMS().imps()) { if ((SETT.ROOMS()).copy.prints.canAdd((RoomBlueprint)b)) { for (Cat c : this.cats) { if (c != null && ((RoomBlueprintImp)c.prints.get(0)).getClass() == b.getClass() && ((RoomBlueprintImp)c.prints.get(0)).constructor().mustBeIndoors() == b.constructor().mustBeIndoors()) { this.catmap[b.index()] = c; (this.catmap[b.index()]).prints.add(b); break; }  }  if (this.catmap[b.index()] == null) { this.catmap[b.index()] = new Cat(b); this.cats.add(this.catmap[b.index()]); }
/*     */          }
/*     */        }
/*  48 */      next(0); } public LIST<Entry> get() { if (this.vi == VIEW.RI())
/*  49 */       return (LIST<Entry>)this.current; 
/*  50 */     this.vi = VIEW.RI();
/*     */     
/*  52 */     int fi = 0;
/*  53 */     this.current.clearSloppy();
/*  54 */     for (Cat c : this.cats) {
/*  55 */       if (c == null) {
/*     */         continue;
/*     */       }
/*  58 */       if (this.filter.text().length() != 0) {
/*  59 */         boolean contains = false;
/*  60 */         for (RoomBlueprintImp b : c.prints) {
/*  61 */           if (Str.containsText(b.info.name, (CharSequence)this.filter.text())) {
/*  62 */             contains = true;
/*     */             break;
/*     */           } 
/*     */         } 
/*  66 */         if (!contains) {
/*     */           continue;
/*     */         }
/*     */       } 
/*  70 */       c.entries = 0;
/*  71 */       boolean hasAny = false;
/*  72 */       boolean locked = true;
/*  73 */       for (RoomBlueprintImp b : c.prints) {
/*  74 */         if ((SETT.ROOMS()).copy.prints.all((RoomBlueprint)b).size() > 0) {
/*  75 */           hasAny = true;
/*  76 */           c.entries += (SETT.ROOMS()).copy.prints.all((RoomBlueprint)b).size();
/*     */         } 
/*  78 */         if (b.reqs.passes(FACTIONS.player())) {
/*  79 */           locked = false;
/*     */         }
/*     */       } 
/*  82 */       if (!hasAny) {
/*     */         continue;
/*     */       }
/*  85 */       Entry e = next(fi);
/*  86 */       fi++;
/*  87 */       e.cat = c;
/*  88 */       e.print = null;
/*  89 */       this.current.add(e);
/*     */       
/*  91 */       int nn = this.current.size();
/*     */       
/*  93 */       for (RoomBlueprintImp b : c.prints) {
/*  94 */         for (SavedPrints.SavedPrint p : (SETT.ROOMS()).copy.prints.all((RoomBlueprint)b)) {
/*  95 */           e = next(fi);
/*  96 */           if (c.expanded)
/*  97 */             this.current.add(e); 
/*  98 */           fi++;
/*  99 */           e.cat = c;
/* 100 */           e.print = p;
/* 101 */           e.isLocked = locked;
/*     */         } 
/*     */       } 
/*     */       
/* 105 */       for (; nn < this.current.size(); nn++) {
/* 106 */         e.isLocked = locked;
/*     */       }
/*     */       
/* 109 */       if (c.entries == 0) {
/* 110 */         c.expanded = false;
/*     */       }
/*     */     } 
/* 113 */     return (LIST<Entry>)this.current; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void expand(SavedPrints.SavedPrint p) {
/* 118 */     (this.catmap[p.blue.index()]).expanded = true;
/* 119 */     this.vi = -1;
/*     */   }
/*     */   
/*     */   private Entry next(int fi) {
/* 123 */     if (fi >= this.free.size()) {
/* 124 */       ArrayList<Entry> free = new ArrayList(this.free.size() + 64);
/* 125 */       ArrayList<Entry> current = new ArrayList(free.max());
/* 126 */       for (Entry e : this.free)
/* 127 */         free.add(e); 
/* 128 */       for (Entry e : this.current)
/* 129 */         current.add(e); 
/* 130 */       for (int i = 0; i < 64; i++)
/* 131 */         free.add(new Entry()); 
/* 132 */       this.free = free;
/* 133 */       this.current = current;
/*     */     } 
/*     */     
/* 136 */     return (Entry)this.free.get(fi);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\prints\List.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */