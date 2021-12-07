export PATH := $(abspath ./tools):/usr/lib/jvm/java-1.8.0-amazon-corretto/bin/:$(PATH)
.PHONY: test
compileclj:
	@echo "\nRecompiling Clojure files"
	lein do clean, deps, compile

startclj:
	@echo "\nStarting a Clojure Repl"
	lein trampoline repl :headless

clj: compileclj startclj

test: compileclj
	@echo "\nRunning all tests"
	lein test

clean:
	lein clean

rebl: compileclj
	@echo "\nStarting a Clojure REBL"
	lein trampoline with-profile +rebl repl :headless

format-check: clean
	@echo "\nRunning clj-kondo lint"
	clj-kondo --lint .
	@echo "\nRunning cljstyle in check mode"
	cljstyle check .
